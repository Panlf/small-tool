package com.plf.tool.common.http;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author panlf
 * @date 2023/7/21
 */
public class HttpClientUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String ENCODING = "UTF-8";

    /**
     * keep alive策略
     * 在HTTP 1.0中，每一次请求响应之后，下一次的请求需要断开之前的连接，再重新开始
     * 在HTTP 1.1中，使用keep-alive在一次TCP连接中可以持续发送多份数据而不会断开连接
     * @author zhuzl
     *
     */
    private static class DefaultConnectionKeepAliveStategy implements ConnectionKeepAliveStrategy {
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext arg1) {
            HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value = he.getValue();
                if (value != null && param.equalsIgnoreCase("timeout")) {
                    return Long.parseLong(value) * 1000;
                }
            }
            return 60 * 1000;// 如果没有约定，则默认定义时长为60s
        }
    }

    /**
     * http连接池中的空闲连接管理
     *
     * @author zhuzl
     *
     */
    public static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than 30 sec
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                LOG.error("httpclient空闲连接监控线程终止.", ex);
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }

    }

    /**
     * 建立全局共享的httpclient
     */
    private static CloseableHttpClient httpClient = null;
    static {
        // http 连接池
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(10);
        connectionManager.setDefaultMaxPerRoute(200);// 例如默认每路由最高50并发，具体依据业务来定
        // 从连接池中获取连接的时间最长为100ms，建立与服务端通信的时间最长为1秒，处理业务最长时间为10秒
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000).setConnectTimeout(1000)
                .setSocketTimeout(10000).build();

        ConnectionKeepAliveStrategy kaStrategy = new DefaultConnectionKeepAliveStategy();
        // 获取httpClient
        httpClient = HttpClients.custom().setConnectionManager(connectionManager).setKeepAliveStrategy(kaStrategy)
                .setDefaultRequestConfig(requestConfig).build();

        // 控制空闲连接
        IdleConnectionMonitorThread idleConnectionMonitor = new IdleConnectionMonitorThread(connectionManager);
        idleConnectionMonitor.start();

    }

    /**
     * Get 请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGetWithHeader(url, null, null);
//		return doGet(url, null);
    }

    /**
     * Get 请求， 参数以Map形式传入，拼接到URI中。使用URIBuilder创建
     *
     * @param url
     * @param param
     * @return
     */
    public static String doGet(String url, Map<String, String> param) {
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("Accept", "text/plain;charset=UTF-8");
            // 执行请求
            response = httpClient.execute(httpGet);
            System.out.println("response:" + response);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            } else {
                resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            }
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            LOG.error("HttpClientUtil.doGet for '" + url + "' return error." + e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }
        return resultString;
    }

    /**
     * Get 请求， 参数以Map形式传入，拼接到URI中。使用URIBuilder创建
     *
     * @param url
     * @param param
     * @return
     */
    public static String doGetWithHeader(String url, Map<String, String> headers, Map<String, String> param) {
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 设置参数并创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 封装请求头
            if (headers != null) {
                Set<Entry<String, String>> entrySet = headers.entrySet();
                for (Entry<String, String> entry : entrySet) {
                    // 设置到请求头到HttpRequestBase对象中
                    httpGet.setHeader(entry.getKey(), entry.getValue());
                }
            }
            httpGet.setHeader("Accept", "text/plain;charset=UTF-8");
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            } else {
                resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            }
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            LOG.error("HttpClientUtil.doGet for '" + url + "' return error." + e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }
        return resultString;
    }

    /**
     * 调用无参的POST请求
     *
     * @param url
     * @return
     */
    public static String doPost(String url) {
        return doPost(url, null);
    }

    /**
     * 基于字符串&拼接的查询条件(形如param=“name=123&age=23”)
     *
     * @param url
     * @param param
     * @return
     */
    public static String doPostWithStringParam(String url, String param) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // httpClient.
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(param, ENCODING);
            httpPost.setEntity(reqEntity);
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpPost.setHeader("Accept", "*/*");
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("HttpClientUtil.doPost for " + url + " return error." + e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }

        return resultString;
    }

    /**
     * 以Map形式传递form参数
     *
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url, Map<String, String> param) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, ENCODING);
                httpPost.setEntity(entity);
            }
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setHeader("Accept", "text/plain;charset=UTF-8");

            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), ENCODING);
        } catch (Exception e) {
            LOG.error("HttpClientUtil.doPost for " + url + " return error." + e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }

        return resultString;
    }

    /**
     * post 传递JSON格式的参数 (将json字符串转为map格式传递)
     *
     * @param url
     * @param json
     * @return
     */
    public static String doPostWithJson(String url, String json) {
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept", "text/plain;charset=UTF-8");
            // 创建请求内容
            if (!StringUtils.isEmpty(json)) {
                StringEntity entity = new StringEntity(json,ENCODING);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }
        return resultString;
    }

    /**
     * post 传递JSON格式的参数 (将json字符串转为map格式传递)
     *
     * @param url
     * @param json
     * @return
     */
    public static String doPostJson(String url, String json) {
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setHeader("Accept", "text/plain;charset=UTF-8");
            // 创建请求内容
            if (!StringUtils.isEmpty(json)) {
                JSONObject jsonObject = JSONObject.parseObject(json);
                Map<String, Object> map = jsonObject.getInnerMap();
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, ENCODING);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                LOG.error("close response failed.", e);
            }
        }
        return resultString;
    }

    /**
     * 发送post请求；带请求头和请求参数
     *
     * @param url
     *            请求地址
     * @param headers
     *            请求头集合
     * @param params
     *            请求参数集合
     * @return
     * @throws Exception
     */
    public static String doPostWithHeader(String url, Map<String, String> headers, Map<String, Object> params) {
        CloseableHttpResponse response = null;
        String resultString = "";

        // 创建http对象
        HttpPost httpPost = new HttpPost(url);
        // 封装请求头
        if (params != null) {
            Set<Entry<String, String>> entrySet = headers.entrySet();
            for (Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Accept", "text/plain;charset=UTF-8");

        // 创建参数列表
        if (params != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : params.keySet()) {
                paramList.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            // 模拟表单
            UrlEncodedFormEntity entity;
            try {
                entity = new UrlEncodedFormEntity(paramList, ENCODING);
                httpPost.setEntity(entity);
                // 执行http请求
                response = httpClient.execute(httpPost);
                resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error("close response failed.", e);
                }
            }
        }

        return resultString;
    }

}



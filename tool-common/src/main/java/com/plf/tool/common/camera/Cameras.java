package com.plf.tool.common.camera;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panlf
 * @date 2026/1/8
 */
public class Cameras {
    // 平台配置（请替换为实际值）
    private static final String HOST = "ip:port";
    private static final String APP_KEY = "appKey";
    private static final String APP_SECRET = "appSecret";
    private static final String ARTEMIS_PATH = "/artemis";

    static {
        // 初始化Artemis配置
        ArtemisConfig.host = HOST;
        ArtemisConfig.appKey = APP_KEY;
        ArtemisConfig.appSecret = APP_SECRET;
    }

    /**
     * 分页获取监控点资源
     * @param pageNo 页码（从1开始）
     * @param pageSize 每页数量（最大1000）
     * @return 监控点列表
     */
    public static JSONObject getCamerasByPage(int pageNo, int pageSize) {
        String previewURLsApi = ARTEMIS_PATH + "/api/resource/v1/cameras";
        Map<String, String> path = new HashMap<String, String>() {{
            put("https://", previewURLsApi); // 根据实际环境选择http/https
        }};

        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", pageNo);
        jsonBody.put("pageSize", pageSize);
        // 可选参数：treeCode（区域编码）、cameraName（监控点名称模糊查询）等

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(
                path, body, null, null, contentType, null
        );

        return JSONObject.parseObject(result);
    }

    /**
     * 获取所有监控点资源（自动分页循环）
     * @return 所有监控点列表
     */
    public static List<JSONObject> getAllCameras() {
        List<JSONObject> allCameras = new ArrayList<>();
        int pageNo = 1;
        int pageSize = 100; // 每页最大数量
        int total;

        do {
            JSONObject result = getCamerasByPage(pageNo, pageSize);
            //System.out.println(result);
            if (result.getInteger("code") != 0) {
                System.err.println("获取监控点失败，错误信息：" + result.getString("msg"));
                break;
            }

            JSONObject data = result.getJSONObject("data");
            total = data.getInteger("total");
            JSONArray list = data.getJSONArray("list");

            for (int i = 0; i < list.size(); i++) {
                allCameras.add(list.getJSONObject(i));
            }

            pageNo++;
        } while ((pageNo - 1) * pageSize < total);

        return allCameras;
    }

    public static JSONObject getRegions() {
        String apiUrl = "/artemis/api/resource/v1/regions";
        Map<String, String> path = new HashMap<String, String>() {{
            put("https://", apiUrl);
        }};
        String contentType = "application/json";
        // 空请求体即可
        String body = "{}";
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);
        return JSONObject.parseObject(result);
    }

    public static JSONObject getPreviewURLs(String cameraIndexCode) {
        String previewURLsApi = ARTEMIS_PATH + "/api/video/v1/cameras/previewURLs";
        Map<String, String> path = new HashMap<String, String>() {{
            put("https://", previewURLsApi); // 根据实际环境选择http/https
        }};

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", cameraIndexCode);
        jsonBody.put("streamType", 0);
        jsonBody.put("protocol", "rtsp");
        jsonBody.put("transmode", 1);

        String contentType = "application/json";

        // 可选参数：treeCode（区域编码）、cameraName（监控点名称模糊查询）等

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(
                path, body, null, null, contentType, null
        );

        return JSONObject.parseObject(result);
    }




    public static void main(String[] args) {
        List<JSONObject> allCameras = getAllCameras();
        System.out.println("获取到监控点总数：" + allCameras.size());
        if (!allCameras.isEmpty()) {
           allCameras.forEach(x-> System.out.println(JSONObject.toJSONString(x)));
       }
    }
}

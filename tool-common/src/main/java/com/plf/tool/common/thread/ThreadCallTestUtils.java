package com.plf.tool.common.thread;

import com.plf.tool.common.http.OkHttpUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @author panlf
 * @date 2023/2/20
 */
public class ThreadCallTestUtils {

    public static void threadCallTest(String url,int threadNum) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for(int i=0;i<threadNum;i++){
            new Thread(()->{
                System.out.println(OkHttpUtils.builder().url(url).get().sync());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}

package com.plf.tool.common.websocket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author panlf
 * @date 2023/6/12
 */
@Slf4j
public class WebSocketClientTest extends WebSocketClient {

    public WebSocketClientTest(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {

    }

    @Override
    public void onMessage(String s) {
        log.info(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }

    public static void main(String[] args) throws Exception {
        WebSocketClientTest webSocketClientTest = new WebSocketClientTest(new URI("ws://192.168.10.103:9000/hello"));
        webSocketClientTest.connect();
        while (!webSocketClientTest.getReadyState().equals(ReadyState.OPEN)){
            log.error("还没有连接...");
            Thread.sleep(1000);
        }
        webSocketClientTest.send("Hello");
        //webSocketClientTest.close();
    }
}

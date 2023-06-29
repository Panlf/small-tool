package com.plf.tool.jdbc.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PortProxy {
    public static void main(String[] args) throws IOException {
        int localPort = 12345; // 本地监听的端口
        String remoteHost = "localhost"; // 远程服务器主机名
        int remotePort = 3306; // 远程服务器端口

        ServerSocket serverSocket = new ServerSocket(localPort);

        while (true) {
            Socket localSocket = serverSocket.accept(); // 接受客户端连接请求

            Socket remoteSocket = new Socket(remoteHost, remotePort); // 建立与远程服务器的连接

            // 创建两个线程，分别实现两个socket之间的数据交换
            Thread t1 = new Thread(new SocketCopyThread(localSocket.getInputStream(), remoteSocket.getOutputStream()));
            Thread t2 = new Thread(new SocketCopyThread(remoteSocket.getInputStream(), localSocket.getOutputStream()));

            t1.start();
            t2.start();
        }
    }
}

class SocketCopyThread implements Runnable {
    private InputStream input;
    private OutputStream output;

    public SocketCopyThread(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[4096];
            int len;

            while ((len = input.read(buffer)) > 0) {
                output.write(buffer, 0, len);
                output.flush(); // 确保所有数据都被写入输出流
            }
        } catch (IOException e) {
            // ignore
        }
    }
}


package com.plf.tool.common.ocr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 将每帧视频转成图片
 * @author Lancer
 * @date 2025-04-05
 */
public class VideoToFrames {
    public static void main(String[] args) {
        // 输入视频文件路径
        String inputVideoPath = "D:\\TempData\\Video\\4月5日.mp4";
        // 输出图片的路径格式（FFmpeg 会自动生成一系列图片）
        String outputImagePath = "D:\\TempData\\Video\\output\\frame_%04d.png";

        // 构造 FFmpeg 命令
        String ffmpegCommand = String.format(
                "ffmpeg -i %s -vf fps=1 %s",
                inputVideoPath, outputImagePath
        );

        try {
            // 使用 ProcessBuilder 执行命令
            ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand.split(" "));
            processBuilder.redirectErrorStream(true); // 合并标准输出和错误输出

            Process process = processBuilder.start();

            // 读取 FFmpeg 的输出日志
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待进程结束
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("视频转换成功！");
            } else {
                System.out.println("视频转换失败，退出码：" + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

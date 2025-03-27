package com.plf.tool.common.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ffmpeg 安装教程  https://www.cnblogs.com/wwwwariana/p/18191233
 * @author panlf
 * @date 2025/3/27
 */
public class FFmpegInfo {

    public static void main(String[] args) {
        String videoFilePath = "C:\\Users\\Breeze\\Downloads\\龙背上的骑兵3片头CG.realesrgan.mkv";
        try {
            // 获取分辨率
            String resolution = getVideoResolution(videoFilePath);
            System.out.println("分辨率: " + resolution);

            // 获取帧率
            String frameRate = getVideoFrameRate(videoFilePath);
            System.out.println("帧率: " + frameRate + " fps");

            // 获取码率
            String bitRate = getVideoBitRate(videoFilePath);
            System.out.println("码率: " + bitRate + " kbps");


            // 获取编码格式
            String codec = getVideoCodec(videoFilePath);
            System.out.println("编码格式: " + codec);

            // 获取色深
            String bitDepth = getVideoBitDepth(videoFilePath);
            System.out.println("色深: " + bitDepth + " bits");

            // 获取色度抽样
            String chromaSubsampling = getVideoChromaSubsampling(videoFilePath);
            System.out.println("色度抽样: " + chromaSubsampling);

            // 获取动态范围
            String dynamicRange = getVideoDynamicRange(videoFilePath);
            System.out.println("动态范围: " + dynamicRange);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getVideoResolution(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=width,height -of csv=s=x:p=0 " + videoFilePath;
        return executeCommand(command);
    }

    public static String getVideoFrameRate(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=r_frame_rate -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        String output = executeCommand(command);
        String[] parts = output.split("/");
        if (parts.length == 2) {
            double frameRate = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
            return String.format("%.2f", frameRate);
        }
        return output;
    }

    public static String getVideoBitRate(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=bit_rate -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        String output = executeCommand(command);
        try {
            double bitRate = Double.parseDouble(output) / 1000;
            return String.format("%.2f", bitRate);
        } catch (NumberFormatException e) {
            return output;
        }
    }

    public static String getVideoCodec(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=codec_name -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        return executeCommand(command);
    }

    public static String getVideoBitDepth(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=bits_per_raw_sample -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        return executeCommand(command);
    }

    public static String getVideoDynamicRange(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=color_transfer -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        return executeCommand(command);
    }


    public static String getVideoChromaSubsampling(String videoFilePath) throws IOException, InterruptedException {
        String command = "ffprobe -v error -select_streams v:0 -show_entries stream=chroma_location -of default=noprint_wrappers=1:nokey=1 " + videoFilePath;
        return executeCommand(command);
    }


    private static String executeCommand(String command) throws IOException, InterruptedException {
        // 在 Windows 下需要使用 cmd.exe 来执行命令
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        Process process = processBuilder.start();

        // 读取命令的标准输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // 读取命令的错误输出
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder errorOutput = new StringBuilder();
        while ((line = errorReader.readLine()) != null) {
            errorOutput.append(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("FFmpeg command failed with exit code: " + exitCode + ". Error output: " + errorOutput);
        }

        return output.toString();
    }
}

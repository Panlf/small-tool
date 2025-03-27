package com.plf.tool.common.video;

import org.jcodec.api.JCodecException;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mkv.demuxer.MKVDemuxer;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;

import java.io.IOException;

/**
 * @author panlf
 * @date 2025/3/27
 */
public class ReadVideo {
    public static void main(String[] args) {
        try {
           // File videoFile = new File("your_video_file.mp4");
            // 获取视频信息
            String filePath  = "C:\\Users\\Breeze\\Downloads\\龙背上的骑兵3片头CG.realesrgan.mkv";
            getVideoInfoMKV(filePath);
        } catch (IOException | JCodecException e) {
            e.printStackTrace();
        }
    }

    public static void getVideoInfoMKV(String filePath) throws IOException, JCodecException {
        // 打开文件通道
        SeekableByteChannel channel = NIOUtils.readableFileChannel(filePath);

        MKVDemuxer mkvDemuxer = new MKVDemuxer(channel);
        System.out.println("分辨率: " + mkvDemuxer.getPictureWidth() + "x" + mkvDemuxer.getPictureHeight());

    }



    public static void getVideoInfo(String filePath) throws IOException, JCodecException {
        //String ext = FileNameUtil.extName(new File(filePath));

        // 打开文件通道
        SeekableByteChannel channel = NIOUtils.readableFileChannel(filePath);

        // 解析MP4文件
        MP4Demuxer demurer = MP4Demuxer.createMP4Demuxer(channel);
        MovieBox movie = demurer.getMovie();
        // 获取视频轨道
        DemuxerTrack videoTrack = demurer.getVideoTrack();

        // 获取分辨率
        Size size = videoTrack.getMeta().getVideoCodecMeta().getSize();
        System.out.println("分辨率: " + size.getWidth() + "x" + size.getHeight());

        // 获取帧率
        float frameRate = videoTrack.getMeta().getTotalFrames() / (float) videoTrack.getMeta().getTotalDuration();
        System.out.println("帧率: " + frameRate + " fps");

        long movieDuration = movie.getDuration();
        long fileSize = channel.size();
        // 获取码率

        System.out.println("码率: " + (fileSize/1024*8/(movieDuration/1000))  + " kbps");

        // 关闭通道
        channel.close();
    }
}

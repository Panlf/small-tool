package com.plf.tool.common.ocr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 经过缩放
 * @author panlf
 * @date 2025/3/18
 */
public class ImageFitScreenExample {
    public static void main(String[] args) {
        try {
            // 禁用高 DPI 缩放
            System.setProperty("sun.java2d.uiScale", "1");

            // 加载图片
            BufferedImage image = ImageIO.read(new File("D:\\TempData\\Video\\output\\frame_0011.png"));
            if (image == null) {
                System.out.println("图片加载失败，请检查路径！");
                return;
            }

            // 获取屏幕尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            // 创建 JFrame
            JFrame frame = new JFrame("图片铺满屏幕");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 添加图片到 JPanel
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    // 计算图片缩放比例
                    double imageRatio = (double) image.getWidth() / image.getHeight();
                    double screenRatio = (double) screenWidth / screenHeight;

                    int drawWidth, drawHeight;
                    if (imageRatio > screenRatio) {
                        // 图片宽高比大于屏幕宽高比，按宽度缩放
                        drawWidth = screenWidth;
                        drawHeight = (int) (screenWidth / imageRatio);
                    } else {
                        // 图片宽高比小于等于屏幕宽高比，按高度缩放
                        drawHeight = screenHeight;
                        drawWidth = (int) (screenHeight * imageRatio);
                    }

                    // 计算绘制起点位置，使图片居中
                    int x = (screenWidth - drawWidth) / 2;
                    int y = (screenHeight - drawHeight) / 2;

                    // 绘制图片
                    g.drawImage(image, x, y, drawWidth, drawHeight, this);
                }

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(screenWidth, screenHeight); // 设置面板大小为屏幕大小
                }
            };

            // 监听鼠标点击事件
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("点击位置: x=" + e.getX() + ", y=" + e.getY());
                }
            });

            // 将 JPanel 添加到 JFrame
            frame.add(panel);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 最大化窗口
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.plf.tool.common.ocr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author panlf
 * @date 2025/3/18
 */
public class ImageClickExample {
    public static void main(String[] args) {
        try {
            // 禁用高 DPI 缩放
            System.setProperty("sun.java2d.uiScale", "1");

            // 加载图片
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Breeze\\Desktop\\11.png"));
            if (image == null) {
                System.out.println("图片加载失败，请检查路径！");
                return;
            }

            // 创建 JFrame
            JFrame frame = new JFrame("选择区域");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 添加图片到 JPanel
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // 缩放图片以适应面板大小
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(image.getWidth(), image.getHeight());
                }
            };

            // 监听鼠标点击事件
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("点击位置: x=" + e.getX() + ", y=" + e.getY());
                }
            });

            // 使用 JScrollPane 支持滚动
            JScrollPane scrollPane = new JScrollPane(panel);
            frame.add(scrollPane);

            // 设置窗口大小
            frame.setSize(800, 600); // 可根据需要调整
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

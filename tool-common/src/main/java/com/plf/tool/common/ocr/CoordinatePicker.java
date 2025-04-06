package com.plf.tool.common.ocr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 经过缩放，xy值会出现偏移
 * @author panlf
 * @date 2025/3/18
 */
public class CoordinatePicker {
    public static void main(String[] args) {
        try {
            // 加载图片
            BufferedImage image = ImageIO.read(new File("D:\\TempData\\Video\\output\\frame_0001.png"));
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
                    g.drawImage(image, 0, 0, this);
                }

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(image.getWidth(), image.getHeight());
                }
            };

            frame.add(panel);

            // 监听鼠标点击事件
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("点击位置: x=" + e.getX() + ", y=" + e.getY());
                }
            });

            // 自动调整窗口大小以适应内容
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

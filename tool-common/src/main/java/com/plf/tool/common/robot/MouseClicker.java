package com.plf.tool.common.robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MouseClicker {
    public static void main(String[] args) {
        try {
            // 创建一个Robot对象
            Robot robot = new Robot();

            // 创建一个定时器，每隔60秒（1分钟）执行一次任务
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // 获取当前鼠标位置
                    int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
                    int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
                    System.out.println("点击一下");
                    // 在当前鼠标位置执行鼠标左键单击操作
                    robot.mouseMove(x, y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }
            }, 0, 60 * 1000); // 延迟0毫秒后开始执行，每隔60秒执行一次
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

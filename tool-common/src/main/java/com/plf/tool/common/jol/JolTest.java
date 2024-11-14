package com.plf.tool.common.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author panlf
 * @date 2024/11/13
 */
public class JolTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}

package com.plf.tool.common.html;

import com.alibaba.fastjson.JSON;
import jodd.jerry.Jerry;

/**
 * @author panlf
 * @date 2025/7/28
 */
public class ParseHtml {

    public static void main(String[] args) {
        String html = "<div data-v-80039eec='' class='pin-content-row middle-row'><div data-v-08787267='' data-v-80039eec=''" +
                " class='content-box content-box'><!----> <span data-v-08787267='' " +
                "class='content content-d-bot'>你努力的样子，真的很美。<a href='www.baidu.com'>baidu</a></span> <div data-v-08787267='' class='limit-ctl-box'><!----> <!---->" +
                "</div> <div data-v-487cbd49='' data-v-78a63d78='' data-v-08787267='' class='popover-box user-popover'><!----> </div></div></div>";

        Jerry doc = Jerry.jerry(html);
        //String title = doc.find("span").text();
        //System.out.println("Title: " + title);

        System.out.println(doc.find(".content-d-bot").text());
        System.out.println(doc.find("a").attr("href"));

    }
}

package com.plf.tool.common.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author panlf
 * @date 2025/6/22
 */
public class ZhihuCrawler {
    public static void main(String[] args) {
        // 设置 ChromeDriver 路径（Windows 下）
        System.setProperty("webdriver.chrome.driver", "C:/Users/Breeze/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // 启动浏览器（可设置无头模式）
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // 可选：无头模式
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriver driver = new ChromeDriver(options);

        try {
            // 知乎问答链接（请替换为你要爬取的问题链接）
            String url = "https://www.zhihu.com/";
            driver.get(url);

            // xpath语法
            WebElement element = driver.findElement(new By.ByXPath("//*[text()='登录/注册']"));
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.invisibilityOf(element));

            // 元素消失后的操作
            System.out.println("元素已消失，可以继续执行后续步骤...");

            Thread.sleep(60 * 1000 * 60);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭浏览器
//            driver.quit();
        }
    }
}

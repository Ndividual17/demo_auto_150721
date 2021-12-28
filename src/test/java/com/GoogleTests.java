package com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GoogleTests {

    public WebDriver webDriver;

    @Test
    public void googleTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://google.com");
        String title = webDriver.getTitle();
        Assert.assertEquals("Google", title);
        webDriver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
//        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium" + Keys.ENTER);
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).submit();

        webDriver.quit();
    }
}

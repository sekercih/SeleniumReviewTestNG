package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
String str="https://the-internet.herokuapp.com/javascript_alerts";
        WebElement button=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String mesaj=driver.switchTo().alert().getText();
        System.out.println(mesaj);

        driver.switchTo().alert().sendKeys(str);
        Thread.sleep(5000);
        driver.switchTo().alert().accept(); //kabul etmek için

        driver.switchTo().alert().dismiss(); //iptal etmek için

    }
    @Test
    public void basic_auth(){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
       //  driver.switchTo().alert().sendKeys("admin");
        //driver.switchTo().alert().sendKeys("admin"+Keys.TAB+"admin"+Keys.TAB);

        WebElement pagemesaj=driver.findElement(By.xpath("//p"));
        System.out.println(pagemesaj.getText());


    }
}

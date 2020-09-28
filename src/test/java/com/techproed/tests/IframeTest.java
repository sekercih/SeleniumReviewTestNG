package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    WebDriver driver;
    @Test
    public void Iframe(){ //mce_0_ifr
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/iframe");
      driver.switchTo().frame("mce_0_ifr");

      WebElement pTag=driver.findElement(By.xpath("//p"));
      pTag.clear();
      pTag.sendKeys("Selamlar");
      driver.switchTo().defaultContent();
      WebElement elementSelenium=driver.findElement(By.xpath("//a[@target='_blank']"));
      elementSelenium.click();
      driver.quit();




    }
}

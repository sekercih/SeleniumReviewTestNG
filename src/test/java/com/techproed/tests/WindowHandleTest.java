package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        String ilkSyfa=driver.getWindowHandle();
        WebElement click=driver.findElement(By.linkText("Click Here"));
        click.click();

        driver.switchTo().window(ilkSyfa);
        for (int i=0; i<10;i++){
            click.click();
            driver.switchTo().window(ilkSyfa);
        }
        // Açık olan tüm pencerelerin window handle'larını almak
        Set<String> tumWindowHandlelar = driver.getWindowHandles();
        for (String handle : tumWindowHandlelar){
            System.out.println(handle);
        }


    }

}

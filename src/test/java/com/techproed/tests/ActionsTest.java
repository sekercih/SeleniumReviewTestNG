package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {
    @Test
    public void sagTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions=new Actions(driver);
        WebElement rightClickMe = driver.findElement(By.xpath("//span[.='right click me']"));
        actions.contextClick(rightClickMe).perform();
        actions.perform();



    }
    @Test
    public void doubleClick(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions=new Actions(driver);
        WebElement doubleClick=driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick);

    }

    @Test
    public void hoverOver(){ // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }
    @Test
    public void asagiYukariGitme() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.END).perform();
        actions.sendKeys(Keys.END,Keys.PAGE_UP).perform();
        Thread.sleep(10);
        actions.sendKeys(Keys.ALT).perform();
    }
    @Test
    public void keysUpKeyDown(){
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.name("q"));
        actions.moveToElement(aramaKutusu).
                click().keyUp(Keys.SHIFT).
                sendKeys("merhaba").keyDown(Keys.SHIFT).sendKeys(" canim"+Keys.ENTER).
                perform();

    }
    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        // ALT + F4 : sayfayı kapatması gerekiyor
        actions.sendKeys(Keys.chord(Keys.CONTROL, "A")).
                build().perform();

    }
}

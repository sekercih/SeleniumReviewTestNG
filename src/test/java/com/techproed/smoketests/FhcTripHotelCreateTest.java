package com.techproed.smoketests;
import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class FhcTripHotelCreateTest extends TestBase {
    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void test() throws InterruptedException {
        FhcTripHotelCreatePage createPage = new FhcTripHotelCreatePage(driver);
        createPage.codeKutusu.sendKeys("Karadeniz");
        createPage.nameKutusu.sendKeys("Batı Karadeniz");
        createPage.adressKutusu.sendKeys("Tuna Cad. No:100/1");
        createPage.phoneKutusu.sendKeys("+905554442211");
        createPage.emailKutusu.sendKeys("karadeniz@gmail.com");
        Select select=new Select(createPage.idGroupDropDown);
        select.selectByIndex(1);
        createPage.saveButonu.click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(createPage.succes.isDisplayed());
        Assert.assertEquals(createPage.succes.getText(),"Hotel was inserted successfully");
        System.out.println(createPage.succes.getText());
       //createPage.basarili.click();

    }
}
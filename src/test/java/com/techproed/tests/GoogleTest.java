package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBaseFinal {
    GooglePage googlePage=new GooglePage();
    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("Techproeducation",
                "Google sonuçları arandı");
        extentTest.info("Google.com' agidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("google"));
        extentTest.info("Google.com'da techproeducation arandi ");
        googlePage.google.sendKeys("techproeducation"+ Keys.ENTER);
        Thread.sleep(3000);

        boolean testSonucu=false;
        for(WebElement w : googlePage.linkler){
            if(w.getText().contains("techproeducation.com123")){
                testSonucu = true;
                break;
            }
        }
        extentTest.info("Asser islemi yapıyoruz");
        Assert.assertTrue(testSonucu);
        extentTest.pass("Test basarili");
    }
}





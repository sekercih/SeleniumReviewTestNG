package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        // Şuanda bulunduğumuz klasörün dosya yolunu veriyor.(String olarak)
        System.out.println(   System.getProperty("user.dir")   );
// Kullanıcın ana klasörünün dosya yolunu veriyor. (String olarak)
        System.out.println(   System.getProperty("user.home")   );

        boolean varMi= Files.exists(Paths.get("D:\\proje klasr\\SeleniumReviewTestNG\\pom.xml"));
        System.out.println("varMi ="+varMi);
        Assert.assertTrue(varMi);

    }@Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement choseFile=driver.findElement(By.id("file-upload"));
        choseFile.sendKeys(" C:\\Users\\apple\\Downloads\\logo.png");
    }
    @Test
    public void dosyaDowload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement penguen=driver.findElement(By.xpath("//a[.='Penguins.jpg']"));
        penguen.click();
        Thread.sleep(4000);
        boolean varMi=Files.exists(Paths.get("C:\\Users\\apple\\Downloads\\Penguins.jpg"));
        Assert.assertTrue(varMi);

        //boolean varMi=Files.exists(Paths"")

    }
}

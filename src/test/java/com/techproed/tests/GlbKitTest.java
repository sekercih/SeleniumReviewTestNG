package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GlbKitTest {
    @Test
    public void test(){

        GlbKitPage glbKitPage=new GlbKitPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("bardak"));

        glbKitPage.yaldizlibardak.click();
        System.out.println(glbKitPage.baslik.getText());
        System.out.println(glbKitPage.fiyat.getText());
        System.out.println(glbKitPage.aciklama.getText());

}  }

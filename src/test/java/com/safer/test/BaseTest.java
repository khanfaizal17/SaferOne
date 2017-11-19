package com.safer.test;

import com.safer.objLib.GlobalObjLib;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    WebDriverWait wait;
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    protected void testSetup() {
        softAssert = new SoftAssert();
        ChromeDriverManager.getInstance().setup();
        if(webDriver==null) {
            webDriver = new ChromeDriver();
            wait = new WebDriverWait(webDriver, 10);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
    @AfterClass(alwaysRun = true)
    protected void testCleanup() {
        if(webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    protected void getPage(String url) {
        if (!StringUtils.isBlank(url)) {
            webDriver.get(GlobalObjLib.URLStartString + GlobalObjLib.URLAddress + url);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

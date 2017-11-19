package com.safer.test;

import com.safer.appLib.SiteAdmin;
import com.safer.util.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;

import com.safer.objLib.*;

public class SaferAdminLoginTest extends BaseTest {

    SiteAdmin siteAdmin;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        super.testSetup();
        siteAdmin = new SiteAdmin(webDriver, softAssert);
        getPage(GlobalObjLib.URLLoginString);

    }

    @Test(groups = { "smoke","full" })
    public void Required_validation() {
        siteAdmin.required_FieldValidation();
        softAssert.assertAll();
    }

    @Test(groups = { "smoke" ,"full"}, dataProvider = "getInvalidCredentials")
    public void Failed_login(String username, String password) {
        siteAdmin.failedlogin(username, password);
        softAssert.assertAll();
    }

    @Test(groups = { "full" })
    public void successful_login() {
        siteAdmin.loginToSafer(GlobalObjLib.username, GlobalObjLib.password);
        softAssert.assertAll();
    }

    @DataProvider(name = "getInvalidCredentials")
    public static Object[][] getInvalidCredentials() {
        return new Object[][] { { "testuser_1", "Test@123" }, { "#@$$#!@$!@", "(!@##&@$(!*@(@!*" }};
    }
}

  	
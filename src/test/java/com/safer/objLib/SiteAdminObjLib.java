package com.safer.objLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteAdminObjLib {

    @FindBy(xpath = "//*[@id='x-auto-1-input']")
    protected WebElement Email_Input_Field;

    @FindBy(xpath = "//*[@id='x-auto-0-input']")
    protected WebElement Password_Input_Field;

    @FindBy(xpath = "//*[@id='x-auto-2']")
    protected WebElement RememberMe_Checkbox;

    @FindBy(xpath = "//*[text()='Sign In']")
    protected WebElement Signin_Button;

    @FindBy(xpath = "//*[text()='Forgot Password']")
    protected WebElement Forgot_Password_Link;

    @FindBy(linkText = "Forgot Password")
    protected WebElement Forgot_Password_Link_one;

    @FindBy(xpath = "//*[@id='x-auto-1']/img")
    protected WebElement Email_RequiredField_Validation_Sign;

    @FindBy(xpath = "//*[@id='x-auto-0']/img")
    protected WebElement Password_RequiredField_Validation_Sign;

    @FindBy(xpath = "//*[text()='Login failed. Please try again !']")
    protected WebElement Validation_Message_Text;

    @FindBy(xpath = "//div[@role='menubar'][2]/table/tbody/tr/td[2]")
    protected  WebElement Loggedin_Username;

    @FindBy(xpath = "//td[text()='Logout']")
    protected WebElement Logout_Text;

}

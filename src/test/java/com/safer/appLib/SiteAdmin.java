package com.safer.appLib;

import com.safer.objLib.SiteAdminObjLib;
import com.safer.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class SiteAdmin extends SiteAdminObjLib{

    SoftAssert softAssert;

    public SiteAdmin(WebDriver driver, SoftAssert softAssert) {
        PageFactory.initElements(driver, this);
        this.softAssert = softAssert;
    }


    /***************************************
     * Set login Email Address
     **************************************/
    public void setEmailaddress(String email) {
        if (Email_Input_Field.isDisplayed() & Email_Input_Field.isEnabled())
            Email_Input_Field.sendKeys(email);

    }

    /**************************************
     * Set Login Password
     ************************************************/

    public void setPassword(String pass) {
        if (Password_Input_Field.isDisplayed() & Password_Input_Field.isEnabled())
            Password_Input_Field.sendKeys(pass);
    }

    /**********************************
     * Sign in button
     *****************************************************/
    public void SignIn_Button() {
        if (Signin_Button.isDisplayed() & Signin_Button.isEnabled())
            Signin_Button.click();
    }

    /****************************************************
     * Email address requied validation
     ********************************/
    public void EmailRequired() {
        this.setPassword(Constants.Password);
        this.SignIn_Button();
        softAssert.assertTrue(Email_RequiredField_Validation_Sign.isDisplayed(), "Email is mandatory field");
    }

    /***********************************
     * Password required field validation
     *****************************************************/
    public void PasswordRequired() {
        this.setEmailaddress(Constants.Email);
        this.SignIn_Button();

        softAssert.assertTrue(Password_RequiredField_Validation_Sign.isDisplayed(), "Password is mandatory field");

    }

    /********************************
     * both field required validation
     ************************************************************/
    public void mandatoryfields() {
        this.SignIn_Button();
        softAssert.assertTrue(Email_RequiredField_Validation_Sign.isDisplayed() & Password_RequiredField_Validation_Sign.isDisplayed(),
                "Email and Password is mandatory fields");
    }

    /*****************************************************
     * Required field validation
     ******************************************/
    public void required_FieldValidation() {
        mandatoryfields();
        EmailRequired();
        Password_Input_Field.clear();
        PasswordRequired();
        Email_Input_Field.clear();
    }

    /********************************************
     * Login failed with mismatch data
     **********************************************/
    public void failedlogin(String sEmail, String sPassword) {

        this.setEmailaddress(sEmail);
        this.setPassword(sPassword);
        this.SignIn_Button();
        softAssert.assertTrue(Validation_Message_Text.isDisplayed(), "incorrect failed login message" + Validation_Message_Text.getText());
        Email_Input_Field.clear();
        Password_Input_Field.clear();
    }

    /*******************************************
     * to do login into system
     **************************************************************/
    public void loginToSafer(String sEmail, String sPassword) {
        this.setEmailaddress(sEmail);
        this.setPassword(sPassword);

        if (!RememberMe_Checkbox.isSelected()) {
            RememberMe_Checkbox.click();
        }
        this.SignIn_Button();
        //TODO: Change to real logic
        softAssert.assertTrue(1==2, "Login was not successful.");

    }

    /*****************************************************
     * Forgot password link availability
     **********************************************/
    public void Forgot_PasswordLink_Presence() {
        if (Forgot_Password_Link.isDisplayed() & Forgot_Password_Link.isEnabled())
            Forgot_Password_Link.click();

    }

}

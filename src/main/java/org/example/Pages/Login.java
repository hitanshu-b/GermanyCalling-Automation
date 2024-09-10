package org.example.Pages;

import org.example.Base.CommonFunctions;
import org.example.Utils.PropertyReader;
import org.openqa.selenium.By;

public class Login extends CommonFunctions {

    public Login() {
    }

    By userEmail = By.id("username");
    By userPassword = By.id("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By errorMessage = By.xpath("//div[@class='alert alert-danger']");
    By errorMessage1 = By.xpath("//div[@class='alert alert-danger']//ul");

//    By email_error = By.xpath("//div[@class='alert alert-danger']//ul/li[contains(text(),'Email')]");
//    By password_error = By.xpath("//div[@class='alert alert-danger']//ul/li[contains(text(),'Password')]");

    public void loginAction_positive() {     // Valid UserEmail and Password
        enterInput(userEmail, PropertyReader.readKey("valid_emailid"));
        enterInput(userPassword, PropertyReader.readKey("valid_password"));
        clickElement(loginButton);
    }

    public String loginAction_negative1() {   // Invalid UserEmail and Valid Password
        enterInput(userEmail, PropertyReader.readKey("invalid_emailid1"));
        enterInput(userPassword, PropertyReader.readKey("valid_password"));
        clickElement(loginButton);
        presenceOfElement(errorMessage);
        return getElementText(errorMessage);
    }

    public String loginAction_negative2() {   // Valid UserEmail and Invalid Password
        enterInput(userEmail, PropertyReader.readKey("valid_emailid"));
        enterInput(userPassword, PropertyReader.readKey("invalid_password1"));
        clickElement(loginButton);
        return getElementText(errorMessage);
    }

    public String loginAction_negative3() {   // Blank UserEmail and Password
        enterInput(userEmail, PropertyReader.readKey("invalid_emailid2"));
        enterInput(userPassword, PropertyReader.readKey("invalid_password2"));
        clickElement(loginButton);
        return getElementText(errorMessage1);
    }

    public String loginAction_negative4() {   // Blank UserEmail and Valid Password
        enterInput(userEmail, PropertyReader.readKey("invalid_emailid2"));
        enterInput(userPassword, PropertyReader.readKey("valid_password"));
        clickElement(loginButton);
        return getElementText(errorMessage);
    }

    public String loginAction_negative5() {   // Valid UserEmail and Blank Password
        enterInput(userEmail, PropertyReader.readKey("valid_emailid"));
        enterInput(userPassword, PropertyReader.readKey("invalid_password2"));
        clickElement(loginButton);
        return getElementText(errorMessage);
    }

    public String loginAction_negative6() {   // User Not Registered
        enterInput(userEmail, PropertyReader.readKey("not_registered_email"));
        enterInput(userPassword, PropertyReader.readKey("not_registered_password"));
        clickElement(loginButton);
        presenceOfElement(errorMessage);
        return getElementText(errorMessage);
    }

    public HomePage afterSuccessfulLogin() {
        return new HomePage();
    }

}

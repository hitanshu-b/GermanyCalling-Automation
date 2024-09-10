package org.example.Tests;

import io.qameta.allure.Description;
import org.example.BaseTest.CommonTests;
import org.example.Pages.HomePage;
import org.example.Pages.Login;
import org.example.Utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends CommonTests {
    Login login = new Login();

    @Test
    @Description("TC001 - Positive Test Case for Login")
    public void validLogin(){
        login.openURL();
        login.loginAction_positive();
        HomePage homePage = login.afterSuccessfulLogin();
        String expectedUsername = homePage.loggedInUser();
        Assert.assertEquals(expectedUsername, PropertyReader.readKey("expectedUsername"));
    }

    @Test
    @Description("TC002 - User Not Registered")
    public void invalidLogin(){
        login.openURL();
        String errorMessage = login.loginAction_negative6();
        Assert.assertEquals(errorMessage, PropertyReader.readKey("error_message"));
    }

    @Test
    @Description("TC003 - Invalid Useremail and Valid Password")
    public void invalidLogin1(){
        login.openURL();
        String errorMessage = login.loginAction_negative1();
        Assert.assertEquals(errorMessage,PropertyReader.readKey("error_message"));
    }

    @Test
    @Description("TC004 - Valid Useremail and Invalid Password")
    public void invalidLogin2(){
        login.openURL();
        String errorMessage = login.loginAction_negative2();
        Assert.assertEquals(errorMessage,PropertyReader.readKey("error_message"));
    }

    @Test
    @Description("TC005 - Blank Useremail and Password")
    public void invalidLogin3(){
        login.openURL();
        String errorMessage = login.loginAction_negative3();
        Assert.assertEquals(errorMessage,PropertyReader.readKey("error_message1"));
    }

    @Test
    @Description("TC005 - Blank Useremail and Valid Password")
    public void invalidLogin4(){
        login.openURL();
        String errorMessage = login.loginAction_negative4();
        Assert.assertEquals(errorMessage,PropertyReader.readKey("error_message2"));
    }

    @Test
    @Description("TC003 - Valid Useremail and Blank Password")
    public void invalidLogin5(){
        login.openURL();
        String errorMessage = login.loginAction_negative5();
        Assert.assertEquals(errorMessage,PropertyReader.readKey("error_message3"));
    }

}

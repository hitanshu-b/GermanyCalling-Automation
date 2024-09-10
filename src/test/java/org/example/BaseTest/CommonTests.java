package org.example.BaseTest;

import io.qameta.allure.Description;
import org.example.DriverManager.Manager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTests {

    @BeforeMethod
    @Description("Open the Browser")
    public void openBrowser(){
        Manager.init();
    }

    @AfterMethod
    @Description("Close the Browser")
    public void closeBrowser(){
        Manager.down();
    }
}

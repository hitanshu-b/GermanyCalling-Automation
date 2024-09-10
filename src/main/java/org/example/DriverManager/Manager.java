package org.example.DriverManager;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class Manager {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void unLoad(){
        dr.remove();
    }

    @BeforeMethod
    @Description("Initialize the Browser")
    public static void init(){
        if(Objects.isNull(Manager.getDriver())){
            WebDriver driver = new EdgeDriver();
            setDriver(driver);
        }
    }

    @AfterMethod
    @Description("Close the Browser")
    public static void down(){
        if(Objects.nonNull(Manager.getDriver())){
            getDriver().quit();
            unLoad();
        }
    }
}

package org.example.Base;

import org.example.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.DriverManager.Manager.getDriver;

public class CommonFunctions {

    public void openURL() {
        getDriver().get(PropertyReader.readKey("url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String input) {
        getDriver().findElement(by).sendKeys(input);
    }

    public String getElementText(By by) {
        return getDriver().findElement(by).getText();
    }

/*    public WebElement explicitWait(int waitTimeInSeconds, By by){
      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTimeInSeconds));
      return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      }
*/
    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
}

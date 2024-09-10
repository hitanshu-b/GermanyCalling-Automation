package org.example.Pages;

import org.example.Base.CommonFunctions;
import org.openqa.selenium.By;

public class HomePage extends CommonFunctions {
    public HomePage() {
    }

    By userName = By.xpath("//a[@id='dropdownUser1']");

    public String loggedInUser() {
        presenceOfElement(userName);
        return getElementText(userName);
    }
}
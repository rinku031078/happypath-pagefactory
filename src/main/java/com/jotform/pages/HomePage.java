package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (css = "#jfCard-welcome-start")
    WebElement startButton;

    public void clickOnStartButton(){
        doClickOnElement(startButton);
        CustomListeners.test.log(Status.PASS,"Click on start button: " );
    }

}

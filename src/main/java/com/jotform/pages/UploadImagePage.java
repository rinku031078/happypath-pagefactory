package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadImagePage extends Utility {

    public UploadImagePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//button[@class='jfInput-button forSubmit form-submit-button u-right']")
    WebElement submitButton;

    public void clickOnSubmitButton() throws InterruptedException {
        Thread.sleep(1000);
        doClickOnElement(submitButton);
        CustomListeners.test.log(Status.PASS,"Click on submit button " );
    }

}

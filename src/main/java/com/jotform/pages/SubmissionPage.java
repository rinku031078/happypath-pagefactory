package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionPage extends Utility {

    public SubmissionPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//h1[contains(text(),'Thank You!')]")
    WebElement thankYouMessage;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Your submission has been received!')]")
    WebElement submissionMessage;

    public void verifyFormSubmission(String message){
        doVerifyElements(thankYouMessage,"Thank You!", "Thank You!");
        CustomListeners.test.log(Status.PASS,"Verify Thank You! message: " + thankYouMessage);
        verifyThatTextIsDisplayed(submissionMessage, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Your submission has been received!' message: " + message);
    }


}

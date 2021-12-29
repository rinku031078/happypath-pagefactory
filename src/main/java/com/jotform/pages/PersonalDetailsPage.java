package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends Utility {

    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "first_2")
    WebElement firstName;

    @CacheLookup
    @FindBy (id = "last_2")
    WebElement lastName;

    @CacheLookup
    @FindBy (xpath = "(//button[contains(@class,'jfInput-button forNext')])[1]")
    WebElement nextButton;

    public void enterFirstName(String fName, String lname) throws InterruptedException {
        doSendTextToElement(firstName, fName);
        CustomListeners.test.log(Status.PASS,"Enter first name: " + fName);
        doSendTextToElement(lastName, lname);
        CustomListeners.test.log(Status.PASS,"Enter last name: " + lname);
        Thread.sleep(1000);
        doClickOnElement(nextButton);
        CustomListeners.test.log(Status.PASS,"Click on next button: " );
    }

    public void clickOnNextButton(){
        doClickOnElement(nextButton);
    }


}

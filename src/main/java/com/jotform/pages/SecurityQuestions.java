package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityQuestions extends Utility {

    public SecurityQuestions() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//div[@class='jfDropdown-chipContainer']")
    WebElement dropdown;

    @CacheLookup
    @FindBy (id = "input_6_field_2")
    WebElement answerField;

    @CacheLookup
    @FindBy (xpath = "//li[contains(text(),'Favourite School')]")
    WebElement favouriteSchool;

    @CacheLookup
    @FindBy (xpath = "//div[@data-type='control_mixed']//button[@aria-label='Next'][normalize-space()='Next']")
    WebElement nextButton;

    public void selectSecurityQuestion(String answer) throws InterruptedException {
        doClickOnElement(dropdown);
        CustomListeners.test.log(Status.PASS,"Click on dropdown: " );
        Thread.sleep(2000);
        doMouseHoverAndClick(favouriteSchool);
        CustomListeners.test.log(Status.PASS,"Select favourite school from dropdown: " + favouriteSchool);
        doSendTextToElement(answerField, answer);
        CustomListeners.test.log(Status.PASS,"Enter answer: " + answer);
        Thread.sleep(1000);
//        doSelectByVisibleTextFromDropDown(dropdown,question);
        doClickOnElement(nextButton);
        CustomListeners.test.log(Status.PASS,"Click on next button: ");
    }

    public void answerSecurityQuestion(String answer) throws InterruptedException {
        Thread.sleep(1000);
        doSendTextToElement(answerField, answer);
    }

}

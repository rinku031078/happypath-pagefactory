package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignaturePage extends Utility {

    public SignaturePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "(//button[contains(@class,'jfInput-button forNext')])[3]")
    WebElement nextButton;

    @CacheLookup
    @FindBy (tagName = "canvas")
    WebElement canvas;


    public void drawSignature() throws InterruptedException {

        doClickOnElement(canvas);
        CustomListeners.test.log(Status.PASS,"Click on canvas for signature: ");
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(canvas)
                .clickAndHold()
                .moveToElement(canvas,20,20)
                .release(canvas)
                .clickAndHold()
                .moveByOffset(-50, 60)
                .moveByOffset(-60, -70)
                .moveByOffset(150, 60)
                .moveByOffset(-60, -70)
                .doubleClick()
                .build();
        drawAction.perform();

        Thread.sleep(5000);
        CustomListeners.test.log(Status.PASS,"Draw Signature: ");
        doClickOnElement(nextButton);
        CustomListeners.test.log(Status.PASS,"Click on next button: " );
    }

    public void clickOnNextButton(){
        doClickOnElement(nextButton);
    }

}


//            .clickAndHold()
//            .moveToElement(canvas,-10,-30)
//            .moveByOffset(30, -50)
//            .moveByOffset(50,-10)
//            .moveByOffset(100,50)
//            .release(canvas)
//            .build();
//        drawAction.perform();
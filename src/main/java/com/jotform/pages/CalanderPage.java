package com.jotform.pages;

import com.aventstack.extentreports.Status;
import com.jotform.customlisteners.CustomListeners;
import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalanderPage extends Utility {

    public CalanderPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//span[@aria-label='Calendar icon']//*[name()='svg']")
    WebElement calanderIcon;

    @CacheLookup
    @FindBy (css = ".button.nextMonth")
    WebElement nextMonthBtn;

    @CacheLookup
    @FindBy (id = "calendar-container-5")
    WebElement calander;

    @CacheLookup
    @FindBy (xpath = "//td[normalize-space()='31']")
    WebElement date;

    @CacheLookup
    @FindBy (css = "div[data-type='control_datetime'] button[aria-label='Next']")
    WebElement nextButton;

    public void selectDate() throws InterruptedException {
        Thread.sleep(1000);
        doClickOnElement(calanderIcon);
        CustomListeners.test.log(Status.PASS,"Click on Calander Icon: ");
        Thread.sleep(1000);
        doClickOnElement(date);
        CustomListeners.test.log(Status.PASS,"Select Date " + date );
        Thread.sleep(500);
        doClickOnElement(nextButton);
        CustomListeners.test.log(Status.PASS,"Click on Next button: ");
    }

    public void clickOnCalanderIcon(){
        doClickOnElement(calanderIcon);
        CustomListeners.test.log(Status.PASS,"Click on Calander Icon: " );
    }

    public void clickOnNextButton(){
        doClickOnElement(nextButton);

    }

//    public void selectDate() throws InterruptedException {
//        String year = "2021";
//        String month = "December";
//        String date = "31";
//
//        Thread.sleep(1000);
//        doClickOnElement(calanderIcon); // Opens the date picker
//
//        while (true) {
//            Thread.sleep(1000);
//            String monthYear = driver.findElement(By.xpath("//td[@class='title']")).getText();
//            String arr[] = monthYear.split(" ");
//            String mon = arr[0];
//            String yer = arr[1];
//            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
//                break;
//            } else {
//                doClickOnElement(nextMonthBtn);
//            }
//        }
//
//        Thread.sleep(1000);
//        // Date Selection
//        List<WebElement> allDates = driver.findElements(By.id("calendar_5"));
//        Thread.sleep(1000);
//        for (WebElement dt : allDates) {
//            if (dt.getText().equalsIgnoreCase(date)) {
//                dt.click();
//                break;
//            }
//
//        }
//
//        Thread.sleep(3000);
//
//    }


}

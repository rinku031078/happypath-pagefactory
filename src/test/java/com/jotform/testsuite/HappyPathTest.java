package com.jotform.testsuite;

import com.jotform.customlisteners.CustomListeners;
import com.jotform.pages.*;
import com.jotform.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(CustomListeners.class)
public class HappyPathTest extends TestBase {

    HomePage homePage;
    PersonalDetailsPage personalDetailsPage;
    UploadFilePage uploadFilePage;
    SignaturePage signaturePage;
    CalanderPage calanderPage;
    SecurityQuestions securityQuestions;
    UploadImagePage uploadImagePage;
    SubmissionPage submissionPage;

    @BeforeMethod
    public void initialize(){
        homePage = new HomePage();
        personalDetailsPage = new PersonalDetailsPage();
        uploadFilePage = new UploadFilePage();
        signaturePage = new SignaturePage();
        calanderPage = new CalanderPage();
        securityQuestions = new SecurityQuestions();
        uploadImagePage = new UploadImagePage();
        submissionPage = new SubmissionPage();
    }

    @Test
    public void verifyUserShouldAbleToSubmitFormSuccessfully() throws InterruptedException, AWTException {
        homePage.clickOnStartButton();
        personalDetailsPage.enterFirstName("Peter", "Patel");
        uploadFilePage.uploadFile();
        signaturePage.drawSignature();
        calanderPage.selectDate();
        securityQuestions.selectSecurityQuestion("Hilltop School");
        uploadImagePage.clickOnSubmitButton();
        submissionPage.verifyFormSubmission("Your submission has been received!");


    }

}

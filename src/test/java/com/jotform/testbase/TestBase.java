package com.jotform.testbase;

import com.jotform.propertyreader.PropertyReader;
import com.jotform.utility.Utility;
import org.testng.annotations.BeforeMethod;


public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void setUp(){
        selectBrowser(browser);
    }

//    @AfterMethod (groups = {"sanity", "smoke", "regression"})
//    public void tearDown(){
//        closeBrowser();
//    }
}

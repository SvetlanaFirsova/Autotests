package com.examples.tests;

import com.examples.managers.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Created by Firsova on 16.02.2017.
 */
public class TestBase {
    public ApplicationManager app;
    protected WebDriver driver;




    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app = new ApplicationManager();
        Thread.sleep(1000);
        driver =app.getWebDriverHelper().getDriver();



    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}

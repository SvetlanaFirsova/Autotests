package com.examples.tests;

import com.examples.managers.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import javax.swing.*;


/**
 * Created by Firsova on 16.02.2017.
 */
public class TestBase {
    public ApplicationManager app;
    protected WebDriver driver;



    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        //class getInstance and singleton will be used for starting tests in several browsers at the same time
        app = new ApplicationManager.getInstance();
        Thread.sleep(1000);
        driver =app.getWebDriverHelper().getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
        //ApplicationManager.getInstance().stop();
    }
}

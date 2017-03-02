package com.examples.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




    /**
     * Created by Firsova on 01.03.2017.
     */
    public class HelperWithWebDriverBase {

    protected ApplicationManager manager;
    protected WebDriver driver;

    public HelperWithWebDriverBase(ApplicationManager manager) {

        this.manager = manager;
        driver = manager.getWebDriverHelper().getDriver();
    }

    public void type(String login, String locator) {
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(login);
    }


}

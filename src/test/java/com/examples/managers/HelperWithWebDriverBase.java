package com.examples.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import sun.plugin.javascript.navig.Link;


/**
     * Created by Firsova on 01.03.2017.
     */
    public class HelperWithWebDriverBase {

    protected ApplicationManager manager;
    protected WebDriver driver;
    private By xpath;

    public HelperWithWebDriverBase(ApplicationManager manager) {

        this.manager = manager;
        driver = manager.getWebDriverHelper().getDriver();
    }

    public void type(String login, String locator) {
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(login);
    }


    public WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }

    public void openURL(String s) {
        driver.get(s);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void doubleClickOnRootUser() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(findElement(By.xpath("//li[@class='rootUserBranch jstree-open jstree-last']/a"))).build();
        dblclick.perform();
    }

    public void doubleClickOnSiteRootUser() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(findElement(By.cssSelector("#site_48>a"))).build();
        dblclick.perform();
    }

    public void click(By linkText) {
        findElement(linkText).click();
    }
}

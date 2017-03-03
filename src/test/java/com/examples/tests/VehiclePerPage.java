package com.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/**
 * Created by Firsova on 07.02.2017.
 */

public class VehiclePerPage extends TestBase{


    @Test(priority = 1)
    public void vehicle10() throws Exception {

        GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
        app.getNavigationHelper().logInDms(validGroup);
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getGroupHelper().clickWebsiteButton();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
        driver.findElement(By.id("id_dms_vehicles_per_page")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.findElement(By.cssSelector("option[value=\"10\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.findElement(By.cssSelector("span.out")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

        @Test(priority = 2)
        public void vehicle10Inventory () throws Exception {

            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }

            @Test(priority = 3)
            public void vehicle200 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#tab1 > span")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            driver.findElement(By.cssSelector("option[value=\"200\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("span.out")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.manage().deleteAllCookies();
        }
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 4)
        public void vehicle200Inventory () throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad1);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }

            @Test(priority = 5)
            public void vehicle25 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("option[value=\"25\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("span.out")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.manage().deleteAllCookies();
        }
    ExpectedCondition<Boolean> jsLoad1 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 6)
        public void vehicle25Inventory () throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad2);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }

            @Test(priority = 7)
            public void vehicle100 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            driver.findElement(By.cssSelector("option[value=\"100\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("span.out")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.manage().deleteAllCookies();
        }
    ExpectedCondition<Boolean> jsLoad2 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 8)
        public void vehicle100Inventory () throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad3);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }

            @Test(priority = 9)
            public void vehicle35 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            driver.findElement(By.cssSelector("option[value=\"35\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("span.out")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.manage().deleteAllCookies();
        }
    ExpectedCondition<Boolean> jsLoad3 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 10)
        public void vehicle35Inventory () throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad4);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }

            @Test(priority = 11)
            public void vehicle50 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            driver.findElement(By.cssSelector("option[value=\"50\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("span.out")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.manage().deleteAllCookies();
        }
    ExpectedCondition<Boolean> jsLoad4 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 12)
        public void vehicle50Inventory () throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad5);
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.linkText("Inventory")).click();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@id='pg_inventory-pager']//td[@dir='ltr']/select[@class='ui-pg-selbox']"))).perform();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
        }
            ExpectedCondition<Boolean> jsLoad5 = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
    }

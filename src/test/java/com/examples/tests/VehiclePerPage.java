package com.examples.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
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
        app.getGroupHelper().select10Vehicle();
        app.getNavigationHelper().logOutFromDms();
        app.getGroupHelper().deleteCookie();
    }

    @Test(priority = 2)
        public void vehicle10Inventory () throws Exception {

            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 10 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[1]")).getText().trim(), "10");
        }

    @Test(priority = 3)
            public void vehicle200 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().select200Vehicle();
            app.getNavigationHelper().logOutFromDms();
            app.getGroupHelper().deleteCookie();
        }

        @Test(priority = 4)
        public void vehicle200Inventory () throws Exception {

            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 200 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[6]")).getText().trim(), "200");
        }

            @Test(priority = 5)
            public void vehicle25 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().select25Vehicle();
            app.getNavigationHelper().logOutFromDms();
            app.getGroupHelper().deleteCookie();
        }

        @Test(priority = 6)
        public void vehicle25Inventory () throws Exception {

            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 25 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[2]")).getText().trim(), "25");
        }

            @Test(priority = 7)
            public void vehicle100 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().select100Vehicle();
            app.getNavigationHelper().logOutFromDms();
            app.getGroupHelper().deleteCookie();
        }

        @Test(priority = 8)
        public void vehicle100Inventory () throws Exception {

            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 100 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[5]")).getText().trim(), "100");
        }

            @Test(priority = 9)
            public void vehicle35 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().select35Vehicle();
            app.getNavigationHelper().logOutFromDms();
            app.getGroupHelper().deleteCookie();
        }

        @Test(priority = 10)
        public void vehicle35Inventory () throws Exception {

            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 35 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[3]")).getText().trim(), "35");
        }

            @Test(priority = 11)
            public void vehicle50 () throws Exception {

            app.getGroupHelper().clickSettingsInManeMenu();
            app.getGroupHelper().clickWebsiteButton();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getGroupHelper().select50Vehicle();
            app.getNavigationHelper().logOutFromDms();
            app.getGroupHelper().deleteCookie();
        }

        @Test(priority = 12)
        public void vehicle50Inventory () throws Exception {

            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
            app.getNavigationHelper().logInDms(validGroup);
            app.getGroupHelper().clickSettingsInManeMenu();
            app.getWebDriverHelper().waitForJSandJQueryToLoad();
            app.getNavigationHelper().openInventoryPage();
            app.getGroupHelper().scrollToInventorySelectBox();
            //Check result = 50 vehicles
            Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='inventory-pager_center']/table/tbody/tr/td[8]/select/option[4]")).getText().trim(), "50");
        }

    }

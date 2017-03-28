package com.examples.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Firsova on 07.03.2017.
 */

public class DealerScore extends TestBase{

      @Test (priority = 1)
    public void userEditorMAP2() throws Exception {

        GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
        app.getNavigationHelper().logInDms(validGroup);
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getGroupHelper().openUsersPage();
        app.getGroupHelper().doubleClickOnRootUser();
        Thread.sleep(1000);
        app.getGroupHelper().openAccessTab();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openToolsInAccess();
        app.getGroupHelper().turnMAP2CheckBoxOnInAccess();
        app.getGroupHelper().saveUserSettings();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 2)
    public void userEditorDealerScoreAccess() throws Exception {

        app.getGroupHelper().doubleClickOnRootUser();
        Thread.sleep(1000);
        app.getGroupHelper().openAccessTab();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openToolsInAccess();
        app.getGroupHelper().turnDealerScoreAccess();
        app.getGroupHelper().saveUserSettings();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();

    }

    @Test (priority = 3)
    public void jQueryVersion() throws Exception {

        app.getNavigationHelper().openSettingsPage();
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickWebsiteButton();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickGeneralTab();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().changeJQueryVersion("1.11.2");
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 4)
    public void sitesSettings() throws Exception {

        app.getGroupHelper().clickSettingsInManeMenu();
        driver.findElement(By.xpath(".//*[@id='height_body']/div/div[2]/div/a[9]/div[2]")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().doubleClickOnSiteRootUser();
        driver.findElement(By.linkText("Widgets")).click();
        app.getGroupHelper().turnDealerScoreAccessInWidget();
        driver.findElement(By.xpath("//div[7]/div/a/span")).click();
        driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button[2]")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='jGrowl-notification ui-state-highlight ui-corner-all jgrowl_default_alert']/div[@class='message']")).getText (), "Site successfully saved");
    }

    @Test (priority = 5)
    public void openDealerScoreModul() throws Exception {

        openURL(app.getWebDriverHelper().baseUrl + "/dms/tools/dealer-score");
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = Dealer Score page
        Assert.assertEquals(app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().baseUrl + "/dms/tools/dealer-score"));
    }

    public void openURL(String s) {
        driver.get(s);
    }

    @Test (priority = 6)
    public void compareDateFromWithDateTo() throws Exception {

        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openFromCalendar();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        String dayFrom = driver.findElement(By.cssSelector(".current-month.weekday.selected")).getText().trim();
        String monthFrom = driver.findElement(By.xpath("//div[@id='dp-popup']/h2")).getText().trim();
        String dateFrom = dayFrom +" "+ monthFrom;
        System.out.println("dateFrom is " + dateFrom);
        app.getGroupHelper().selectDateFrom();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openToCalendar();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        String dayTo = driver.findElement(By.cssSelector(".current-month.weekday.today.selected")).getText().trim();
        String monthTo = driver.findElement(By.xpath("//div[@id='dp-popup']/h2")).getText().trim();
        String dateTo = dayTo + " " + monthTo;
        System.out.println("dateTo is " + dateTo);
        app.getGroupHelper().selectDateTo();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        //parses of date
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        Date date = null;
        Date date2 = null;
        try {
            date = df.parse(dateFrom);
            date2 = df.parse(dateTo);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(date);
        cal2.setTime(date2);
        System.out.println("dateFrom is " + date.getTime());
        System.out.println("dateTo is " + date2.getTime());

        Assert.assertTrue(date.getTime() < date2.getTime());
    }

    @Test (priority = 7)
    public void isAlertPresentDateFromMoreThanDateTo() throws Exception {


        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openFromCalendar();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath(".//*[@id='dp-popup']/div[2]/a[1]")).click();
        }
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(".//*[@id='dp-popup']/div[2]/a[2]")).click();
        }
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.findElement(By.xpath(".//*[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='jGrowl-notification ui-state-highlight ui-corner-all jgrowl_default_alert']/div[@class='message']")).getText(), "Start date must be less then finish date");

    }

    @Test (priority = 8)
    public void possibilitySelectDateToEarlierThanDateFromIsAbsent() throws Exception {

        openURL(app.getWebDriverHelper().baseUrl + "/dms/tools/dealer-score");
        app.getWebDriverHelper ().waitForJSandJQueryToLoad ();
        app.getGroupHelper ().openFromCalendar ();
        app.getWebDriverHelper ().waitForJSandJQueryToLoad ();
        String dayFrom = driver.findElement (By.cssSelector (".current-month.weekday.selected")).getText ().trim ();
        String monthFrom = driver.findElement (By.xpath ("//div[@id='dp-popup']/h2")).getText ().trim ();
        String dateFrom = dayFrom + " " + monthFrom;
        System.out.println ("dateFrom is " + dateFrom);
        app.getGroupHelper ().selectDateFrom ();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().openToCalendar();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        for (int i = 0; i < 2; i++) {
            driver.findElement (By.xpath (".//*[@id='dp-popup']/div[1]/a[1]")).click ();
        }
        app.getWebDriverHelper ().waitForJSandJQueryToLoad ();
        WebElement dateDisabled = driver.findElement (By.cssSelector (".other-month.weekend.disabled"));
        dateDisabled.isDisplayed();
        Assert.assertEquals (dateDisabled.isDisplayed(), true);

    }

    @Test (priority = 9)
    public void elementsPresent() throws Exception {
        openURL(app.getWebDriverHelper().baseUrl + "/dms/tools/dealer-score");
        app.getWebDriverHelper ().waitForJSandJQueryToLoad ();
        //driver.findElement (By.linkText ("Customer Service:"));
        Assert.assertTrue (app.getWebDriverHelper().baseUrl + "/dms/tools/dealer-score", "Customer Service:");
    }

/*

           @Test (priority = 7)
        public void open1() throws Exception {

                //driver.findElement(By.cssSelector("a.dp-choose-date")).click();
                driver.findElement(By.xpath("//div[@id='tabs-1']/table/tbody/tr/td[4]/div/a")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr/td[3]")).click();
                driver.findElement(By.xpath("//div[@id='tabs-1']/table/tbody/tr/td[4]/div/a")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<<")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[2]")).click();
                driver.findElement(By.linkText(">>")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[5]/td[4]")).click();
                driver.findElement(By.cssSelector("a.dp-choose-date")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr/td")).click();
                driver.findElement(By.xpath("//div[@id='tabs-1']/table/tbody/tr/td[4]/div/a")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.linkText("<")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[5]/td[3]")).click();
                driver.findElement(By.cssSelector("a.dp-choose-date")).click();
                driver.findElement(By.linkText(">")).click();
                driver.findElement(By.linkText(">")).click();
                driver.findElement(By.linkText(">")).click();
                driver.findElement(By.linkText(">>")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[5]/td[2]")).click();
                driver.findElement(By.linkText("Settings")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[12]/div")).click();
                driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[16]")).click();
                driver.findElement(By.name("jquery_version")).click();
                driver.findElement(By.xpath("(//a[contains(text(),'Save')])[16]")).click();
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.linkText("Make-A-Page 2.0")).click();
                driver.findElement(By.cssSelector("div.map-page-name")).click();
                driver.findElement(By.cssSelector("div.map-link.pull-right")).click();
                driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
                driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("dealer-score-autotest");
                driver.findElement(By.cssSelector("span.mapx-button-ico.widget")).click();
                driver.findElement(By.id("dealer_rating_2017271488898135568")).click();
                driver.findElement(By.id("library-keyword-filter")).clear();
                driver.findElement(By.id("library-keyword-filter")).sendKeys("de");
                driver.findElement(By.xpath("//button[@type='button']")).click();
                driver.findElement(By.cssSelector("div.mapx-button-ico.activate")).click();
                driver.findElement(By.cssSelector("div.close")).click();
                driver.findElement(By.cssSelector("span.mapx-button-ico.style")).click();
                driver.findElement(By.cssSelector("span.mapx-button-ico.page")).click();
                driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
                driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("dealer-score-autotest");
                driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
                driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("dealer-score-autotest");
                driver.findElement(By.cssSelector("div.mapx-button-ico.activate")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
                driver.findElement(By.xpath("//div[@id='toolbar']/ul/li[5]/a/span[2]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
                driver.findElement(By.id("rate_11779")).click();
                driver.findElement(By.id("rate_11791")).click();
                driver.findElement(By.id("rate_11803")).click();
                driver.findElement(By.id("rate_11815")).click();
                driver.findElement(By.id("rate_11827")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11849")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("TestName");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("Testreview");
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[2]/div")).click();
                driver.findElement(By.cssSelector("span")).click();
                driver.findElement(By.cssSelector("g > g > text")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("a.dp-choose-date")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[3]")).click();
                driver.findElement(By.cssSelector("a.dp-choose-date")).click();
                driver.findElement(By.linkText(">")).click();
                driver.findElement(By.xpath("//div[@id='dp-popup']/div[3]/table/tbody/tr[2]/td[3]")).click();
                driver.findElement(By.id("rate_11781")).click();
                driver.findElement(By.id("rate_11793")).click();
                driver.findElement(By.id("rate_11805")).click();
                driver.findElement(By.id("rate_11817")).click();
                driver.findElement(By.id("rate_11829")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.id("rate_11851")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("TestName1");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("TestReview1");
                driver.findElement(By.cssSelector("path")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.id("rate_11783")).click();
                driver.findElement(By.id("rate_11795")).click();
                driver.findElement(By.id("rate_11807")).click();
                driver.findElement(By.id("rate_11819")).click();
                driver.findElement(By.id("rate_11831")).click();
                driver.findElement(By.id("rate_11843")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11853")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("TestName2");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("TestReview2");
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("path")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.id("rate_11785")).click();
                driver.findElement(By.id("rate_11797")).click();
                driver.findElement(By.id("rate_11809")).click();
                driver.findElement(By.id("rate_11821")).click();
                driver.findElement(By.id("rate_11833")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.id("rate_11855")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("TestName3");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("TestReview3");
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.xpath("//div[@id='tabs-1']/div[3]/div[9]/div/div[2]")).click();
                driver.findElement(By.id("rate_11787")).click();
                driver.findElement(By.id("rate_11799")).click();
                driver.findElement(By.id("rate_11811")).click();
                driver.findElement(By.id("rate_11823")).click();
                driver.findElement(By.id("rate_11835")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11857")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("TestName4");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("TestReview4");
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.header-score")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.id("rate_11781")).click();
                driver.findElement(By.id("rate_11791")).click();
                driver.findElement(By.id("rate_11791")).click();
                driver.findElement(By.id("rate_11807")).click();
                driver.findElement(By.id("rate_11785")).click();
                driver.findElement(By.id("rate_11831")).click();
                driver.findElement(By.id("rate_11819")).click();
                driver.findElement(By.id("rate_11851")).click();
                driver.findElement(By.id("dealerRatingName")).clear();
                driver.findElement(By.id("dealerRatingName")).sendKeys("!@#$%^&UIOP@#$%^&<Q>Q,q.q<q>qXHGJJKL< tfygyuyi;ok;ln ttuok vvzf vhgpa9ouip[aD:mcnjhvgfWU WGD AIS");
                driver.findElement(By.id("dealerRatingReview")).clear();
                driver.findElement(By.id("dealerRatingReview")).sendKeys("D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn D YuuWQWGU YHI  IHDOAWUEPHB IWAI I HiasIAshIsop'O;IK PSLADKSJAHVDHHIOIW0928948762354623871292M-435678nc  vb8u9oikji08665e5xc vbn0u8b687bn");
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.linkText("Settings")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[11]/div")).click();
                driver.findElement(By.linkText("[10661]Ksenia Test(test_3@dxloo.com) [36]")).click();
                driver.findElement(By.id("user_13739")).click();
                driver.findElement(By.id("user_editor_tab1")).click();
                driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
                driver.findElement(By.linkText("[10661]Ksenia Test(test_3@dxloo.com) [36]")).click();
                driver.findElement(By.id("user_13737")).click();
                driver.findElement(By.id("user_editor_tab1")).click();
                driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
                driver.findElement(By.linkText("[10661]Ksenia Test(test_3@dxloo.com) [36]")).click();
                driver.findElement(By.linkText("[10661]Ksenia Test(test_3@dxloo.com) [36]")).click();
                driver.findElement(By.id("user_editor_tab1")).click();
                driver.findElement(By.cssSelector("#user_editor_tab4 > span")).click();
                driver.findElement(By.id("go_8")).click();
                driver.findElement(By.id("addon_make_a_page_2")).click();
                driver.findElement(By.xpath("(//a[contains(text(),'Save')])[8]")).click();
                driver.findElement(By.linkText("Settings")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[12]/div")).click();
                driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[16]")).click();
                driver.findElement(By.name("jquery_version")).click();
                driver.findElement(By.name("jquery_version")).clear();
                driver.findElement(By.name("jquery_version")).sendKeys("1.7.2");
                driver.findElement(By.xpath("(//a[contains(text(),'Save')])[16]")).click();
                driver.findElement(By.xpath("//div[@id='idBackRect']/div[2]")).click();
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[2]/div")).click();
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.linkText("Make-A-Page")).click();
                driver.findElement(By.xpath("//div[@id='gallery1-custom']/table/tbody/tr/td[2]")).click();
                driver.findElement(By.xpath("//div[@onclick='page_new(pagetab)']")).click();
                driver.findElement(By.id("input-pg-name")).click();
                driver.findElement(By.id("input-pg-name")).click();
                driver.findElement(By.id("input-pg-name")).click();
                driver.findElement(By.id("input-pg-name")).clear();
                driver.findElement(By.id("input-pg-name")).sendKeys("dealer-score-autotest");
                driver.findElement(By.id("input-pg-name")).click();
                driver.findElement(By.id("input-pg-url")).click();
                driver.findElement(By.id("input-pg-url")).clear();
                driver.findElement(By.id("input-pg-url")).sendKeys("dealer-score-autotest");
                driver.findElement(By.id("input-pg-title")).click();
                driver.findElement(By.id("input-pg-title")).click();
                driver.findElement(By.id("input-pg-title")).clear();
                driver.findElement(By.id("input-pg-title")).sendKeys("dealer-score-autotest");
                driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-next")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer-score-autotest | ]]
                driver.findElement(By.id("lib-back")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.cssSelector("#btn_editwidget > div")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.id("btn_activate")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.xpath("//button[@onclick=\"if (!$(this).hasClass('ui-state-disabled')) {page_BROWSE(gSession.page_current);}\"]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.id("select-right-width")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                new Select(driver.findElement(By.id("select-right-width"))).selectByVisibleText("off");
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.cssSelector("#select-right-width > option[value=\"disabled\"]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.id("select-center-width")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.id("select-right-width")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.id("btn_activate")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
                driver.findElement(By.id("rate_11779")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11791")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11803")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11815")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11827")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11849")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("TestReviewMAP1");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestNameMAP1");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[2]/div")).click();
                driver.findElement(By.cssSelector("path")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
                driver.findElement(By.id("rate_11781")).click();
                driver.findElement(By.id("rate_11781")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11793")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11807")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11819")).click();
                driver.findElement(By.cssSelector("div.modr-car-prew > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-prew > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11805")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11817")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11829")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11851")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("Testreview1MAP1");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestName1MAP1");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.cssSelector("path")).click();
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
                driver.findElement(By.id("rate_11783")).click();
                driver.findElement(By.id("rate_11783")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11795")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11807")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11819")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11831")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11843")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11853")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("TestReview3MAP1");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestName3MAP1");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.id("rate_11785")).click();
                driver.findElement(By.cssSelector("div.modr-car-next")).click();
                driver.findElement(By.id("rate_11797")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11809")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11821")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11833")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11855")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("TestReview3MAP1");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestName3MAP1");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.cssSelector("div.dealerRatingText")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
                driver.findElement(By.id("rate_11787")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11799")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11811")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11823")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11835")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-prew > span")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("rate_11857")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("TestReview4MAP1");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestName4MAP1");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.cssSelector("div.modr-car-next > span")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("UW");
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84     uidwiiwUEO  wuoedwoieoiPQwo5789390-2-=31 18y381y398 v3i4ro3wir whwviejoQW CO ehriw84");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("7643723844533221234657890*^&^#@#$%^&*()_+_)(*^&%$#");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.cssSelector("div.header-score")).click();
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[7]/div")).click();
                driver.findElement(By.xpath("//div[@id='gallery1-custom']/table/tbody/tr/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dealer-score-autotest']/div[2]/li[3]/span/img")).click();
                driver.findElement(By.id("widget-hover")).click();
                driver.findElement(By.cssSelector("#btn_editwidget > div")).click();
                driver.findElement(By.id("prop_0")).click();
                new Select(driver.findElement(By.id("prop_0"))).selectByVisibleText("Square");
                driver.findElement(By.cssSelector("option[value=\"line\"]")).click();
                driver.findElement(By.id("prop_1")).click();
                new Select(driver.findElement(By.id("prop_1"))).selectByVisibleText("#2 Simple Black");
                driver.findElement(By.cssSelector("#prop_1 > option[value=\"black\"]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
                driver.findElement(By.cssSelector("#btn_editwidget > div")).click();
                driver.findElement(By.id("prop_2")).click();
                new Select(driver.findElement(By.id("prop_2"))).selectByVisibleText("columns");
                driver.findElement(By.cssSelector("option[value=\"columns\"]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
                driver.findElement(By.id("btn_activate")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
                driver.findElement(By.xpath("//button[@onclick=\"if (!$(this).hasClass('ui-state-disabled')) {page_BROWSE(gSession.page_current);}\"]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
                driver.findElement(By.id("rate_11779")).click();
                driver.findElement(By.id("rate_11791")).click();
                driver.findElement(By.id("rate_11803")).click();
                driver.findElement(By.id("rate_11815")).click();
                driver.findElement(By.id("rate_11827")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11849")).click();
                driver.findElement(By.id("review")).clear();
                driver.findElement(By.id("review")).sendKeys("TestReviewMAP1part2");
                driver.findElement(By.name("from")).clear();
                driver.findElement(By.name("from")).sendKeys("TestNameMAP1part2");
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[2]/div")).click();
                driver.findElement(By.cssSelector("rect")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
                driver.findElement(By.id("rate_11781")).click();
                driver.findElement(By.id("rate_11793")).click();
                driver.findElement(By.id("rate_11805")).click();
                driver.findElement(By.id("rate_11817")).click();
                driver.findElement(By.id("rate_11829")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.id("rate_11855")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.id("rate_11783")).click();
                driver.findElement(By.id("rate_11795")).click();
                driver.findElement(By.id("rate_11807")).click();
                driver.findElement(By.id("rate_11819")).click();
                driver.findElement(By.id("rate_11831")).click();
                driver.findElement(By.id("rate_11843")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11851")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.id("rate_11785")).click();
                driver.findElement(By.id("rate_11797")).click();
                driver.findElement(By.id("rate_11809")).click();
                driver.findElement(By.id("rate_11821")).click();
                driver.findElement(By.id("rate_11833")).click();
                driver.findElement(By.id("rate_11839")).click();
                driver.findElement(By.id("rate_11847")).click();
                driver.findElement(By.id("rate_11857")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.id("rate_11787")).click();
                driver.findElement(By.id("rate_11799")).click();
                driver.findElement(By.id("rate_11811")).click();
                driver.findElement(By.id("rate_11823")).click();
                driver.findElement(By.id("rate_11835")).click();
                driver.findElement(By.id("rate_11841")).click();
                driver.findElement(By.id("rate_11845")).click();
                driver.findElement(By.id("rate_11853")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                driver.findElement(By.cssSelector("div.modr-submitkey > span")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=dealer_rating_1488899211 | ]]
                driver.findElement(By.linkText("Tools")).click();
                driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/div/a[7]/div")).click();
                driver.findElement(By.xpath("//div[@id='gallery1-custom']/table/tbody/tr/td[2]")).click();
                driver.findElement(By.xpath("//div[@id='dealer-score-autotest']/div[2]/li[3]/span/img")).click();
                driver.findElement(By.id("widget-hover")).click();
                driver.findElement(By.cssSelector("#btn_editwidget > div")).click();
                driver.findElement(By.id("prop_0")).click();
                driver.findElement(By.id("prop_0")).click();
                driver.findElement(By.id("prop_0")).click();
                new Select(driver.findElement(By.id("prop_0"))).selectByVisibleText("Rounded");
                driver.findElement(By.cssSelector("option[value=\"round\"]")).click();
                driver.findElement(By.cssSelector("#prop_1 > option[value=\"default\"]")).click();
                new Select(driver.findElement(By.id("prop_1"))).selectByVisibleText("#3 Simple Light");
                driver.findElement(By.cssSelector("#prop_1 > option[value=\"light\"]")).click();
                driver.findElement(By.id("prop_2")).click();
                driver.findElement(By.id("prop_2")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
                driver.findElement(By.id("select_pg_bg_template")).click();
                new Select(driver.findElement(By.id("select_pg_bg_template"))).selectByVisibleText("# Simple Black");
                driver.findElement(By.cssSelector("option[value=\"karkas_bg-black\"]")).click();
                driver.findElement(By.id("btn_activate")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
                driver.findElement(By.xpath("//button[@onclick=\"if (!$(this).hasClass('ui-state-disabled')) {page_BROWSE(gSession.page_current);}\"]")).click();
                // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
                driver.findElement(By.cssSelector("#btn_editwidget > div")).click();
                driver.findElement(By.cssSelector("#prop_1 > option[value=\"default\"]")).click();
                new Select(driver.findElement(By.id("prop_1"))).selectByVisibleText("#4 Blue & Yellow 1 (023)");
                driver.findElement(By.cssSelector("#prop_1 > option[value=\"tmp_023\"]")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
                driver.findElement(By.id("btn_activate")).click();
        }
*/
}



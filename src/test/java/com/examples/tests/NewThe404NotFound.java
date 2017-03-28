package com.examples.tests;


import org.testng.Assert;
import org.testng.annotations.*;


public
class NewThe404NotFound extends TestBase {


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
    }

    @Test (priority = 2)
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

    @Test (priority = 3)
    public void homePage404() throws Exception {

        app.getNavigationHelper().openSettingsPage();
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getGroupHelper().clickWebsiteButton();
        app.getGroupHelper().editButtonOf404NotFound();
        app.getGroupHelper().field404NotFound();
        app.getGroupHelper().selectHomePageIn404NotFoundField();
        app.getGroupHelper().waitForJSandQueryToLoad();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 4)
    public void RedirectOnHomePage() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = Home page
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().dwsUrl + "/index.html") );
    }

    @Test (priority = 5)
    public void HomeMAP2Deactivate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFestHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().deactivatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 6)
    public void RedirectOnHomePageError() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = page doen't work
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().dwsUrl + "/") );
    }

    @Test (priority = 7)
    public void HomeMAP2Activate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFestHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().activatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 8)
    public void InventoryPage404() throws Exception {

        app.getNavigationHelper().openSettingsPage();
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getGroupHelper().clickWebsiteButton();
        app.getGroupHelper().editButtonOf404NotFound();
        app.getGroupHelper().field404NotFound();
        app.getGroupHelper().selectInventoryPageIn404NotFoundField();
        app.getGroupHelper().waitForJSandQueryToLoad();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 9)
    public void RedirectOnInventoryPage() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().dwsUrl + "/test-inventory.html") );
    }

    @Test (priority = 10)
    public void InventoryMAP2Deactivate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickInventoryPageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFirstInventoryPageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().deactivatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 11)
    public void RedirectFromInventoryOnHomePage() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = Home page
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), ("http://www.svetlana.ixloo.com/") );
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 12)
    public void HomeInvMAP2Deactivate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFestHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().deactivatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 13)
    public void RedirectFromInventoryOnHomePageError() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = page doen't work
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().dwsUrl + "/") );
    }

    @Test (priority = 14)
    public void HomeFromInventoryMAP2Activate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFestHomePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().activatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 15)
    public void InventoryMAP2Activate() throws Exception {

        app.getNavigationHelper().openURLOfMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickInventoryPageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().clickEditOfFirstInventoryPageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        app.getGroupHelper().activatePageInMAP2();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    @Test (priority = 16)
    public void On404Page404() throws Exception {

        app.getNavigationHelper().openSettingsPage();
        app.getGroupHelper().clickSettingsInManeMenu();
        app.getGroupHelper().clickWebsiteButton();
        app.getGroupHelper().editButtonOf404NotFound();
        app.getGroupHelper().field404NotFound();
        app.getGroupHelper().select404NotFoundPageIn404NotFoundField();
        app.getGroupHelper().waitForJSandQueryToLoad();
        //Sleep time
        Thread.sleep(10000);
    }

    @Test (priority = 17)
    public void RedirectOn404Page() throws Exception {

        app.getNavigationHelper().openIncorrectURL();
        app.getWebDriverHelper().waitForJSandJQueryToLoad();
        //Check Result URL = page not found
        Assert.assertEquals( app.getGroupHelper().getCurrentUrl(), (app.getWebDriverHelper().dwsUrl + "/notfound") );
    }
}






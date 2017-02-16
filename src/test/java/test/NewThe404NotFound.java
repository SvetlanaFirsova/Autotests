package test;

import org.testng.Assert;
import org.testng.annotations.*;


public
class NewThe404NotFound extends TestBase {


    @Test (priority = 1)
    public void userEditorMAP2() throws Exception {
        GroupObject validGroup = new GroupObject("sbvu673wrb", "svetlanaf");
        logInDms(validGroup);
        clickSettingsInManeMenu();
        openUsersPage();
        doubleClickOnRootUser();
        Thread.sleep(1000);
        openAccessTab();
        waitForJSandJQueryToLoad();
        openToolsInAccess();
        turnMAP2CheckBoxOnInAccess();
        saveUserSettings();
    }

    @Test (priority = 2)
    public void jQueryVersion() throws Exception {
        openSettingsPage();
        clickSettingsInManeMenu();
        clickWebsiteButton();
        changeJQueryVersion("1.11.2");
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 3)
    public void homePage404() throws Exception {
        openSettingsPage();
        clickSettingsInManeMenu();
        clickWebsiteButton();
        editButtonOf404NotFound();
        field404NotFound();
        selectHomePageIn404NotFoundField();
        waitForJSandQueryToLoad();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 4)
    public void RedirectOnHomePage() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        //Check Result URL = Home page
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/index.html") );
    }

    @Test (priority = 5)
    public void HomeMAP2Deactivate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickHomePageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFestHomePageInMAP2();
        waitForJSandJQueryToLoad();
        deactivatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 6)
    public void RedirectOnHomePageError() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        //Check Result URL = page doen't work
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/") );
    }

    @Test (priority = 7)
    public void HomeMAP2Activate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickHomePageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFestHomePageInMAP2();
        waitForJSandJQueryToLoad();
        activatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 8)
    public void InventoryPage404() throws Exception {
        openSettingsPage();
        clickSettingsInManeMenu();
        clickWebsiteButton();
        editButtonOf404NotFound();
        field404NotFound();
        selectInventoryPageIn404NotFoundField();
        waitForJSandQueryToLoad();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 9)
    public void RedirectOnInventoryPage() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/test-inventory.html") );
    }

    @Test (priority = 10)
    public void InventoryMAP2Deactivate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickInventoryPageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFerstInventoryPageInMAP2();
        waitForJSandJQueryToLoad();
        deactivatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 11)
    public void RedirectFromInventoryOnHomePage() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        //Check Result URL = Home page
        Assert.assertEquals( getCurrentUrl(), ("http://www.svetlana.ixloo.com/") );
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 12)
    public void HomeInvMAP2Deactivate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickHomePageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFestHomePageInMAP2();
        waitForJSandJQueryToLoad();
        deactivatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 13)
    public void RedirectFromInventoryOnHomePageError() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        //Check Result URL = page doen't work
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/") );
    }

    @Test (priority = 14)
    public void HomeFromInventoryMAP2Activate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickHomePageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFestHomePageInMAP2();
        waitForJSandJQueryToLoad();
        activatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 15)
    public void InventoryMAP2Activate() throws Exception {
        openURLOfMAP2();
        waitForJSandJQueryToLoad();
        clickInventoryPageInMAP2();
        waitForJSandJQueryToLoad();
        clickEditOfFerstInventoryPageInMAP2();
        waitForJSandJQueryToLoad();
        activatePageInMAP2();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 16)
    public void On404Page404() throws Exception {
        openSettingsPage();
        clickSettingsInManeMenu();
        clickWebsiteButton();
        editButtonOf404NotFound();
        field404NotFound();
        select404NotFoundPageIn404NotFoundField();
        waitForJSandQueryToLoad();
        //Sleep time
        Thread.sleep(10000);
    }

    @Test (priority = 17)
    public void RedirectOn404Page() throws Exception {
        openIncorrectURL();
        waitForJSandJQueryToLoad();
        //Check Result URL = page not found
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/notfound") );
    }
}






package test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public
class NewThe404NotFound {
    private WebDriver driver;
    private String baseUrl;
    private String dwsUrl;
    private StringBuffer verificationErrors = new StringBuffer();



    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "http://www.svetlana.ixloo.com/dms/login";
        dwsUrl = "http://www.svetlana.ixloo.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitForJSandJQueryToLoad();
    }
    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
    //method for execute Java Script: page should be loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    @Test (priority = 1)
    public void userEditorMAP2() throws Exception {
        logInDms("sbvu673wrb", "svetlanaf");
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


    private String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    private void saveUserSettings() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[8]")).click();
    }

    private void turnMAP2CheckBoxOnInAccess() {
        if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }
    }

    private void openToolsInAccess() {
        driver.findElement(By.xpath("//div[@id='user_editor_access_rights']/div[8]/div/span")).click();
    }

    private void openAccessTab() {
        waitForJSandJQueryToLoad();
        driver.findElement(By.cssSelector("#user_editor_tab4")).click();
        waitForJSandJQueryToLoad();
    }

    private void doubleClickOnRootUser() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.xpath("//li[@class='rootUserBranch jstree-open jstree-last']/a"))).build();
        dblclick.perform();
    }

    private void openUsersPage() {
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/users']")).click();
    }

    private void clickSettingsInManeMenu() {
        driver.findElement(By.linkText("Settings")).click();
    }

    private void logInDms(String password, String login) {
        driver.get(baseUrl + "/dms/login");
        type(password, "password");
        type(login, "login");
        clickLoginButtonInDMS();
    }

    private void clickLoginButtonInDMS() {
        driver.findElement(By.id("login2")).click();
    }

    private void type(String login, String locator) {
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(login);
    }

    private void changeJQueryVersion(String jOuery) {
        driver.findElement(By.cssSelector("#jquery_version > td.tb_r > div.view > span.gl_button.edit_btn > span")).click();
        //Click into jQuery field
        driver.findElement(By.name("jquery_version")).click();
        //Clear jQuery field
        driver.findElement(By.name("jquery_version")).clear();
        //Write 1.11.2 in jQuery field
        driver.findElement(By.name("jquery_version")).sendKeys(jOuery);
        //Click Save jQuery 1.11.2
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[16]")).click();
    }

    private void openSettingsPage() {
        driver.get(baseUrl + "/dms/settings/");
    }

    private void selectHomePageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Home page");
        //Home page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_homepage\"]")).click();
    }

    private void deactivatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
    }

    private void clickEditOfFestHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20168141473859781387']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']")).click();
    }

    private void clickHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
    }

    private void openURLOfMAP2() {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
    }

    private void activatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
    }

    private void waitForJSandQueryToLoad() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
    }

    private void selectInventoryPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Inventory page (default)");
        //Inventory page into select box of "404 not found"
        driver.findElement(By.cssSelector("#redirect_404 > option")).click();
    }

    private void editButtonOf404NotFound() {
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
    }

    private void openIncorrectURL() {
        driver.get(dwsUrl + "/cars112233/");
    }

    private void clickEditOfFerstInventoryPageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
    }

    private void clickInventoryPageInMAP2() {
        driver.findElement(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
    }

    private void select404NotFoundPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Standard \"404 not found\" page");
        //"404 not found" page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_404_not_found\"]")).click();
    }

    private void field404NotFound() {
        driver.findElement(By.name("redirect_404")).click();
    }

    private void clickWebsiteButton() {
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/website']")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}






package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by Firsova on 16.02.2017.
 */
public class TestBase {
    protected String dwsUrl;
    private WebDriver driver;
    private String baseUrl;
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

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void saveUserSettings() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[8]")).click();
    }

    protected void turnMAP2CheckBoxOnInAccess() {
        if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }
    }

    protected void openToolsInAccess() {
        driver.findElement(By.xpath("//div[@id='user_editor_access_rights']/div[8]/div/span")).click();
    }

    protected void openAccessTab() {
        waitForJSandJQueryToLoad();
        driver.findElement(By.cssSelector("#user_editor_tab4")).click();
        waitForJSandJQueryToLoad();
    }

    protected void doubleClickOnRootUser() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.xpath("//li[@class='rootUserBranch jstree-open jstree-last']/a"))).build();
        dblclick.perform();
    }

    protected void openUsersPage() {
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/users']")).click();
    }

    protected void clickSettingsInManeMenu() {
        driver.findElement(By.linkText("Settings")).click();
    }

    protected void logInDms(GroupObject groupObject) {
        driver.get(baseUrl + "/dms/login");
        type(groupObject.getPassword(), "password");
        type(groupObject.getLogin(), "login");
        clickLoginButtonInDMS();
    }

    private void clickLoginButtonInDMS() {
        driver.findElement(By.id("login2")).click();
    }

    private void type(String login, String locator) {
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(login);
    }

    protected void changeJQueryVersion(String jOuery) {
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

    protected void openSettingsPage() {
        driver.get(baseUrl + "/dms/settings/");
    }

    protected void selectHomePageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Home page");
        //Home page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_homepage\"]")).click();
    }

    protected void deactivatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
    }

    protected void clickEditOfFestHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20168141473859781387']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']")).click();
    }

    protected void clickHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
    }

    protected void openURLOfMAP2() {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
    }

    protected void activatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
    }

    protected void waitForJSandQueryToLoad() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
    }

    protected void selectInventoryPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Inventory page (default)");
        //Inventory page into select box of "404 not found"
        driver.findElement(By.cssSelector("#redirect_404 > option")).click();
    }

    protected void editButtonOf404NotFound() {
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
    }

    protected void openIncorrectURL() {
        driver.get(dwsUrl + "/cars112233/");
    }

    protected void clickEditOfFerstInventoryPageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
    }

    protected void clickInventoryPageInMAP2() {
        driver.findElement(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
    }

    protected void select404NotFoundPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Standard \"404 not found\" page");
        //"404 not found" page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_404_not_found\"]")).click();
    }

    protected void field404NotFound() {
        driver.findElement(By.name("redirect_404")).click();
    }

    protected void clickWebsiteButton() {
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

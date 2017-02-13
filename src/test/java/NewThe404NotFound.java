
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
        driver.get(baseUrl + "/dms/login");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("svetlanaf");
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/users']")).click();

        //make a double click
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.xpath("//li[@class='rootUserBranch jstree-open jstree-last']/a"))).build();
        dblclick.perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#user_editor_tab4")).click();
        driver.findElement(By.cssSelector("#go_7")).click();
        driver.findElement(By.xpath("//div[@id='user_editor_access_rights']/div[8]/div/span")).click();

        //turning check-box map2 on
        if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[8]")).click();
    }


    @Test (priority = 2)
    public void jQueryVersion() throws Exception {
        driver.get(baseUrl + "/dms/settings/");
        driver.findElement(By.linkText("Settings")).click();
        //jQuery version 1.11.2
        driver.findElement(By.xpath(".//*[@id='height_body']/div/div[2]/div/a[12]")).click();
        driver.findElement(By.cssSelector("#jquery_version > td.tb_r > div.view > span.gl_button.edit_btn > span")).click();
        driver.findElement(By.name("jquery_version")).click();
        driver.findElement(By.name("jquery_version")).clear();
        driver.findElement(By.name("jquery_version")).sendKeys("1.11.2");
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[16]")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 3)
    public void homePage404() throws Exception {
        driver.get(baseUrl + "/dms/settings/");
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/website']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
        driver.findElement(By.name("redirect_404")).click();
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Home page");
        driver.findElement(By.cssSelector("option[value=\"redir_homepage\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 4)
    public void RedirectOnHomePage() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl(), (dwsUrl + "/index.html") );
    }
    private String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    @Test (priority = 5)
    public void HomeMAP2Deactivate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20170131484314419288']/div[@class='buttons pull-right']/span[@data-action='page_edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 6)
    public void RedirectOnHomePageError() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl1(), (dwsUrl + "/") );
    }
    private String getCurrentUrl1() {
        return driver.getCurrentUrl();
    }

    @Test (priority = 7)
    public void HomeMAP2Activate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20170131484314419288']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 8)
    public void InventoryPage404() throws Exception {
        driver.get(baseUrl + "/dms/settings/");
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/website']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
        driver.findElement(By.name("redirect_404")).click();
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Inventory page (default)");
        driver.findElement(By.cssSelector("#redirect_404 > option")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
        waitForJSandJQueryToLoad();

    }

    @Test (priority = 9)
    public void RedirectOnInventoryPage() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl2(), (dwsUrl + "/test-inventory.html") );
    }
    private String getCurrentUrl2() {
        return driver.getCurrentUrl();
    }

    @Test (priority = 10)
    public void InventoryMAP2Deactivate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 11)
    public void RedirectFromInventoryOnHomePage() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl3(), ("http://www.svetlana.ixloo.com/") );
        waitForJSandJQueryToLoad();
        waitForJSandJQueryToLoad();
    }
    private String getCurrentUrl3() {
        return driver.getCurrentUrl();
    }

    @Test (priority = 12)
    public void HomeInvMAP2Deactivate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20170131484314419288']/div[@class='buttons pull-right']/span[@data-action='page_edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
        waitForJSandJQueryToLoad();
    }

    @Test (priority = 13)
    public void RedirectFromInventoryOnHomePageError() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl4(), (dwsUrl + "/") );
    }
    private String getCurrentUrl4() {
        return driver.getCurrentUrl();
    }


    @Test (priority = 14)
    public void HomeFromInventoryMAP2Activate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20170131484314419288']/div[@class='buttons pull-right']/span[@data-action='page_edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
        waitForJSandJQueryToLoad();

    }

    @Test (priority = 15)
    public void InventoryMAP2Activate() throws Exception {
        driver.get("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
        waitForJSandJQueryToLoad();
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
        waitForJSandJQueryToLoad();

    }

    @Test (priority = 16)
    public void On404Page404() throws Exception {
        driver.get(baseUrl + "/dms/settings/");
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/website']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
        driver.findElement(By.name("redirect_404")).click();
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Standard \"404 not found\" page");
        driver.findElement(By.cssSelector("option[value=\"redir_404_not_found\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 17)
    public void RedirectOn404Page() throws Exception {
        driver.get(dwsUrl + "/cars112233/");
        waitForJSandJQueryToLoad();
        Assert.assertEquals( getCurrentUrl5(), (dwsUrl + "/notfound") );
    }
    private String getCurrentUrl5() {
        return driver.getCurrentUrl();
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






/*
import com.google.common.base.Function;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

*/
/**
 * Created by Firsova on 07.02.2017.
 *//*

public class VehiclePerPage {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "http://www.svetlana.ixloo.com/dms/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 9)
    public void vehicle10() throws Exception {
        driver.get(baseUrl + "/dms/login");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("svetlanaf");
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
        driver.findElement(By.id("id_dms_vehicles_per_page")).click();
        //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("10");
        driver.findElement(By.cssSelector("option[value=\"10\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
        driver.findElement(By.cssSelector("span.out")).click();
    }

        @Test(priority = 10)
        public void vehicle200 () throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until(jsLoad);
            driver.findElement(By.cssSelector("td[title=\"651\"]")).click();
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
            driver.findElement(By.cssSelector("#tab1 > span")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("200");
            driver.findElement(By.cssSelector("option[value=\"200\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            driver.findElement(By.cssSelector("span.out")).click();
        }
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 11)
        public void vehicle25 () throws Exception {
            WebDriverWait wait = new WebDriverWait( driver, 15 );
            wait.until(jsLoad1);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until( jsLoad1 );
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("25");
            driver.findElement(By.cssSelector("option[value=\"25\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            driver.findElement(By.cssSelector("span.out")).click();
        }

    ExpectedCondition<Boolean> jsLoad1 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 12)
        public void vehicle100 () throws Exception {
            WebDriverWait wait = new WebDriverWait( driver, 15 );
            wait.until(jsLoad2);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until( jsLoad2 );
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("100");
            driver.findElement(By.cssSelector("option[value=\"100\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            driver.findElement(By.cssSelector("span.out")).click();
        }
    ExpectedCondition<Boolean> jsLoad2 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };


        @Test(priority = 13)
        public void vehicle35 () throws Exception {
            WebDriverWait wait = new WebDriverWait( driver, 15 );
            wait.until(jsLoad3);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until( jsLoad3 );
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("35");
            driver.findElement(By.cssSelector("option[value=\"35\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            driver.findElement(By.cssSelector("span.out")).click();
        }

    ExpectedCondition<Boolean> jsLoad3 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };

        @Test(priority = 14)
        public void vehicle50 () throws Exception {
            WebDriverWait wait = new WebDriverWait( driver, 15 );
            wait.until(jsLoad4);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until( jsLoad4 );
            driver.findElement(By.linkText("Settings")).click();
            driver.findElement(By.xpath("//div[@id='height_body']/div/div[2]/a[12]/div")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[13]")).click();
            driver.findElement(By.id("id_dms_vehicles_per_page")).click();
            //new Select(driver.findElement(By.id("id_dms_vehicles_per_page"))).selectByVisibleText("50");
            driver.findElement(By.cssSelector("option[value=\"50\"]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Save')])[13]")).click();
            driver.findElement(By.cssSelector("span.out")).click();
        }
    ExpectedCondition<Boolean> jsLoad4 = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };


        @Test(priority = 15)
        public void Inventory () throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(jsLoad5);
            driver.get(baseUrl + "/dms/login");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("sbvu673wrb");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("svetlanaf");
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.linkText("Inventory")).click();
            wait.until(jsLoad5);
        }

            ExpectedCondition<Boolean> jsLoad5 = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };


        @AfterClass(alwaysRun = true)
        public void tearDown () throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    }


*/

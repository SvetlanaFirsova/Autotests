package com.examples.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

/**
 * Created by Firsova on 24.02.2017.
 */
public class WebDriverHelper {

    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    public String dwsUrl;
    public String baseUrl;

    public WebDriverHelper() {

        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://www.svetlana.ixloo.com";
        dwsUrl = "http://www.svetlana.ixloo.com";
        waitForJSandJQueryToLoad();
    }

    public void clickLoginButtonInDMS() {
        driver.findElement(By.id("login2")).click();
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

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

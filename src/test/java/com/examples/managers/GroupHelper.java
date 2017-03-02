package com.examples.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Firsova on 01.03.2017.
 */
public class GroupHelper extends HelperWithWebDriverBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public void saveUserSettings() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[8]")).click();
    }

    public void turnMAP2CheckBoxOnInAccess() {
        if (driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null) {
            manager.getWebDriverHelper().waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }
    }

    public void openToolsInAccess() {
        driver.findElement(By.xpath("//div[@id='user_editor_access_rights']/div[8]/div/span")).click();
    }

    public void openAccessTab() {
        manager.getWebDriverHelper().waitForJSandJQueryToLoad();
        driver.findElement(By.cssSelector("#user_editor_tab4")).click();
        manager.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    public void doubleClickOnRootUser() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.xpath("//li[@class='rootUserBranch jstree-open jstree-last']/a"))).build();
        dblclick.perform();
    }

    public void openUsersPage() {
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/users']")).click();
    }

    public void clickSettingsInManeMenu() {
        driver.findElement(By.linkText("Settings")).click();
    }




    public void changeJQueryVersion(String jOuery) {
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

    public void selectHomePageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Home page");
        //Home page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_homepage\"]")).click();
    }

    public void deactivatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']")).click();
    }

    public void clickEditOfFestHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page-uid='pg_20168141473859781387']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']")).click();
    }

    public void clickHomePageInMAP2() {
        driver.findElement(By.xpath("//div[@data-page='index']/div[@class='map-page-name']")).click();
    }

    public void activatePageInMAP2() {
        driver.findElement(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']")).click();
    }

    public void waitForJSandQueryToLoad() {
        driver.findElement(By.xpath("(//a[contains(text(),'Save')])[17]")).click();
    }

    public void selectInventoryPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Inventory page (default)");
        //Inventory page into select box of "404 not found"
        driver.findElement(By.cssSelector("#redirect_404 > option")).click();
    }

    public void editButtonOf404NotFound() {
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[17]")).click();
    }

    public void clickEditOfFirstInventoryPageInMAP2() {

        driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']")).click();
        //driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
    }

    public void clickInventoryPageInMAP2() {
        driver.findElement(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
    }

    public void select404NotFoundPageIn404NotFoundField() {
        new Select(driver.findElement(By.name("redirect_404"))).selectByVisibleText("Standard \"404 not found\" page");
        //"404 not found" page into select box of "404 not found"
        driver.findElement(By.cssSelector("option[value=\"redir_404_not_found\"]")).click();
    }

    public void field404NotFound() {
        driver.findElement(By.name("redirect_404")).click();
    }

    public void clickWebsiteButton() {
        driver.findElement(By.cssSelector(".big-module-item[href='/dms/settings/website']")).click();
    }


}

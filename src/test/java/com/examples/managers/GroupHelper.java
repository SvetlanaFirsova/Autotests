package com.examples.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Firsova on 01.03.2017.
 */
public class GroupHelper extends HelperWithWebDriverBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }


    public void saveUserSettings() {
        click(By.xpath("(//a[contains(text(),'Save')])[8]"));
    }

    public void turnMAP2CheckBoxOnInAccess() {
        if (findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null) {
            manager.getWebDriverHelper().waitForJSandJQueryToLoad();
            click(By.cssSelector("#addon_make_a_page_2"));
        }
    }

    public void openToolsInAccess() {
        click(By.xpath("//div[@id='user_editor_access_rights']/div[8]/div/span"));
    }

    public void openAccessTab() {
        manager.getWebDriverHelper().waitForJSandJQueryToLoad();
        click(By.cssSelector("#user_editor_tab4"));
        manager.getWebDriverHelper().waitForJSandJQueryToLoad();
    }

    public void openUsersPage() {
        click(By.cssSelector(".big-module-item[href='/dms/settings/users']"));
    }

    public void clickSettingsInManeMenu() {
        click(By.linkText("Settings"));
    }

    public void changeJQueryVersion(String jOuery) {
        click(By.cssSelector("#jquery_version > td.tb_r > div.view > span.gl_button.edit_btn > span"));
        //Click into jQuery field
        click(By.name("jquery_version"));
        //Clear jQuery field
        findElement(By.name("jquery_version")).clear();
        //Write 1.11.2 in jQuery field
        findElement(By.name("jquery_version")).sendKeys(jOuery);
        //Click Save jQuery 1.11.2
        click(By.xpath("(//a[contains(text(),'Save')])[16]"));
    }

    public void selectHomePageIn404NotFoundField() {
        new Select(findElement(By.name("redirect_404"))).selectByVisibleText("Home page");
        //Home page into select box of "404 not found"
        click(By.cssSelector("option[value=\"redir_homepage\"]"));
    }

    public void deactivatePageInMAP2() {
        click(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Deactivate Page (unpublish)']/div[@class='mapx-button-ico deactivate']"));
    }

    public void clickEditOfFestHomePageInMAP2() {
        click(By.xpath("//div[@data-page-uid='pg_20168141473859781387']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']"));
    }

    public void clickHomePageInMAP2() {
        click(By.xpath("//div[@data-page='index']/div[@class='map-page-name']"));
    }

    public void activatePageInMAP2() {
        click(By.xpath("//div[@id='map']/div[@class='topbar noselect']/div[@class='menu-actions']/div[@style='display: block;']/div[@title='Activate Page (publish)']/div[@class='mapx-button-ico activate']"));
    }

    public void waitForJSandQueryToLoad() {
        click(By.xpath("(//a[contains(text(),'Save')])[17]"));
    }

    public void selectInventoryPageIn404NotFoundField() {
        new Select(findElement(By.name("redirect_404"))).selectByVisibleText("Inventory page (default)");
        //Inventory page into select box of "404 not found"
        click(By.cssSelector("#redirect_404 > option"));
    }

    public void editButtonOf404NotFound() {
        click(By.xpath("(//a[contains(text(),'Edit')])[17]"));
    }

    public void clickEditOfFirstInventoryPageInMAP2() {

        click(By.xpath("//div[@data-page-uid='pg_20161091478668955791']/div[@class='buttons pull-right']/span[@data-action='page_edit']/span[@class='mapx-button-ico edit']"));
        //driver.findElement(By.xpath("//div[@data-page-uid='pg_20161091478668955791']//span[@class='mapx-button-ico edit']")).click();
    }

    public void clickInventoryPageInMAP2() {
        click(By.xpath(".//*[@id='map']/div[2]/div[2]/div[1]/div[2]/div[2]"));
    }

    public void select404NotFoundPageIn404NotFoundField() {
        new Select(findElement(By.name("redirect_404"))).selectByVisibleText("Standard \"404 not found\" page");
        //"404 not found" page into select box of "404 not found"
        click(By.cssSelector("option[value=\"redir_404_not_found\"]"));
    }

    public void field404NotFound() {
        click(By.name("redirect_404"));
    }

    public void clickWebsiteButton() {
        click(By.cssSelector(".big-module-item[href='/dms/settings/website']"));
    }


}

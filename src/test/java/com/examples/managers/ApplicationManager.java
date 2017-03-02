package com.examples.managers;


/**
 * Created by Firsova on 24.02.2017.
 */
public class ApplicationManager {

    public WebDriverHelper webDriverHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;



    public ApplicationManager() {
        webDriverHelper = new WebDriverHelper();
        navigationHelper = new NavigationHelper(this);
        groupHelper = new GroupHelper(this);

        //driver = webDriverHelper.getDriver();

    }

    public void stop() {
        webDriverHelper.stop();

    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public WebDriverHelper getWebDriverHelper() {
        return webDriverHelper;
    }


}

package com.examples.managers;


/**
 * Created by Firsova on 24.02.2017.
 */
public class ApplicationManager {

    public WebDriverHelper webDriverHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;



    //public ApplicationManager() {
        //webDriverHelper = new WebDriverHelper();
        //navigationHelper = new NavigationHelper(this);
        //groupHelper = new GroupHelper(this);
    //}

    public void stop() {

        //if webDriverHelper was used it has to be stopped
        if (webDriverHelper != null){
            webDriverHelper.stop();
        }
    }

    public GroupHelper getGroupHelper() {

        //if we need to use Group Helper we will call him
        if (groupHelper == null){
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }


    public NavigationHelper getNavigationHelper() {

        //if we need to use Group Helper we will call him
        if (navigationHelper == null){
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }


    public WebDriverHelper getWebDriverHelper() {

        //if we need to use Group Helper we will call him
        if (webDriverHelper == null){
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
    }
}

package com.examples.managers;


import static com.sun.corba.se.spi.servicecontext.MaxStreamFormatVersionServiceContext.singleton;

/**
 * Created by Firsova on 24.02.2017.
 */
public class ApplicationManager {

    public static ApplicationManager singleton;

    public WebDriverHelper webDriverHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;




    public static ApplicationManager getInstance() {
        if (singleton == null) {

        //class getInstance and singleton will be used for starting tests in several browsers at the same time
        singleton = new ApplicationManager();
        }
        return singleton;
        //webDriverHelper = new WebDriverHelper();
        //navigationHelper = new NavigationHelper(this);
        //groupHelper = new GroupHelper(this);
    }

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

    //class getInstance will be used for starting tests in several browsers at the same time
    public static class getInstance extends ApplicationManager {
    }
}

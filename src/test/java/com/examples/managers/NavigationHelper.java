package com.examples.managers;

import com.examples.tests.GroupObject;


/**
 * Created by Firsova on 01.03.2017.
 */
public class NavigationHelper extends HelperWithWebDriverBase{

       public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void logInDms(GroupObject groupObject) {

        openURL(manager.getWebDriverHelper().baseUrl + "/dms/login");
        type(groupObject.getPassword(), "password");
        type(groupObject.getLogin(), "login");
        manager.getWebDriverHelper().clickLoginButtonInDMS();
    }

    public void openSettingsPage() {
        openURL(manager.getWebDriverHelper().baseUrl + "/dms/settings/");
    }

    public void openURLOfMAP2() {
        openURL("http://www.svetlana.ixloo.com/dms/tools/make_a_page_2");
    }

    public void openIncorrectURL() {
        openURL(manager.getWebDriverHelper().dwsUrl + "/cars112233/");
    }



}

package com.examples.tests;

public class GroupObject extends TestBase {
    private final String password;
    private final String login;

    public GroupObject(String password, String login) {
        this.password = password;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}

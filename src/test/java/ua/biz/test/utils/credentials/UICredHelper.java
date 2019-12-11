package ua.biz.test.utils.credentials;

import java.io.*;
import java.util.Properties;

public final class UICredHelper {

    private String login;
    private String password;
    private static UICredHelper credentialsHelper;

    public static UICredHelper getInstance() {
        if (credentialsHelper == null) {
            credentialsHelper = new UICredHelper();
        }
        return credentialsHelper;
    }

    private UICredHelper() {
        credProperties();
    }

    private void credProperties() {
        Properties properties = new Properties();
        try {
            properties.load(UICredHelper.class.getResourceAsStream("/cred.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        login = properties.getProperty("login");
        password = properties.getProperty("password");
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}

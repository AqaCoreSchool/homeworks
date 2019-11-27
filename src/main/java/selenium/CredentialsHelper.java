package selenium;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public final class CredentialsHelper {

    String sep = File.separator;
    String credFilePath = "src" + sep + "main" + sep + "resourses" + sep + "cred.properties";
    private String login;
    private String password;
    private static CredentialsHelper credentialsHelper;

    public static CredentialsHelper getInstance() {
        if (credentialsHelper == null) {
            credentialsHelper = new CredentialsHelper();
        }
        return credentialsHelper;
    }


    private CredentialsHelper() {
        credProperties();
    }

    private void credProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader(credFilePath)));
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

package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Common {
    private Common() {

    }


    public static String getProperty(String propertyKey) {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir);
        Properties property = new Properties();
        String value = "";
        try(FileInputStream fis = new FileInputStream(path + File.separator + "constants.properties")) {
            property.load(fis);
            value = property.getProperty(propertyKey);
        } catch (IOException e) {
            System.err.println("Property file not found");
        }
        return value;
    }
}

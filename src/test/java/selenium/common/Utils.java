package selenium.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utils {

    private Utils () {
    }

    public static String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String  simpleDateFormat = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        return String.format("%s %s:00 GMT 2", dtf.format(localDate), simpleDateFormat);
    }

    public static LocalDate getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return LocalDate.parse(dtf.format(localDate));
    }

    public static String getProperty(String propertyKey) {
        Path path = Paths.get(System.getProperty("user.dir"));
        Properties property = new Properties();
        String value = "";
        try(FileInputStream fis = new FileInputStream(path + File.separator + "data.properties")) {
            property.load(fis);
            value = property.getProperty(propertyKey);
        } catch (IOException e) {
            System.err.println("Property file not found");
        }
        return value;
    }

    public static int getColumnCount(String prefix) {
        Properties properties = new Properties();
        List<String> propsCount = new ArrayList<>();
        try {
            properties.load(new FileInputStream("data.properties"));
            for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements();) {
                String name = e.nextElement().toString();
                String value = properties.getProperty(name);
                if (name.startsWith(prefix)) {
                    propsCount.add(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propsCount.size();
    }
}

package selenium.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import javax.annotation.Nullable;
import java.awt.image.TileObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

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
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir, "src", "test", "java", "selenium", "common");
        Properties property = new Properties();
        String value = "";
        try(FileInputStream fis = new FileInputStream(path + File.separator + "model_data.properties")) {
            property.load(fis);
            value = property.getProperty(propertyKey);
        } catch (IOException e) {
            System.err.println("Property file not found");
        }
        return value;
    }
}

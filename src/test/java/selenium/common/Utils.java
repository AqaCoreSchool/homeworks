package selenium.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

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
}

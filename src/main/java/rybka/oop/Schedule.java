package rybka.oop;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    public static Map<Film, String> schedule = new HashMap<Film, String>();

    public Map<Film, String> getSchedule() {
        return schedule;
    }

    public static void setSchedule(Film film, String start) {
        schedule.put(film, start);
    }
}

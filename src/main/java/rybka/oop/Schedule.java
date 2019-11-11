package rybka.oop;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    public static Map<String, Film> schedule = new HashMap<String, Film>();

    public Map<String, Film> getSchedule() {
        return schedule;
    }

    public static void setSchedule(String start, Film film) {
        schedule.put(start, film);
    }
}

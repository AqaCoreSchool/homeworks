package Homework1;

public enum DaysOfWeek {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String day;

    DaysOfWeek(String day) {
        this.day = day;
    }
    public String day() {
        return this.day;
    }
}

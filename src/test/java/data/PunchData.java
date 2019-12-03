package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PunchData {
    private String punchInMessage;
    private String punchOutMessage;
    private String todayDate;
    private String weekBefore;
    private String weekAfter;

    public PunchData() {
        this.punchInMessage = "Start punch message";
        this.punchOutMessage = "End punch message";
        this.todayDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.weekBefore = LocalDateTime.now().minusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
        this.weekAfter = LocalDateTime.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
    }

    public String getPunchInMessage() {
        return punchInMessage;
    }

    public String getPunchOutMessage() {
        return punchOutMessage;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public String getWeekBefore() {
        return weekBefore;
    }

    public String getWeekAfter() {
        return weekAfter;
    }
}

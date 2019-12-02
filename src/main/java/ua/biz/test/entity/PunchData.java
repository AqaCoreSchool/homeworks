package ua.biz.test.entity;

public class PunchData {
    private String punchInTime;
    private String punchOutTime;
    private String punchInMessage;
    private String punchOutMessage;

    public PunchData(String punchInMessage, String punchOutMessage) {
        this.punchInMessage = punchInMessage;
        this.punchOutMessage = punchOutMessage;
    }

    public String getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(String punchInTime) {
        this.punchInTime = punchInTime;
    }

    public String getPunchOutTime() {
        return punchOutTime;
    }

    public void setPunchOutTime(String punchOutTime) {
        this.punchOutTime = punchOutTime;
    }

    public String getPunchInMessage() {
        return punchInMessage;
    }

    public String getPunchOutMessage() {
        return punchOutMessage;
    }
}

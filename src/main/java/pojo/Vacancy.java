package pojo;

public class Vacancy {
    private String jobTitle = "1";
    private String position;
    private int managerValue = 1;


    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPosition() {
        return position;
    }

    public int getManagerValue() {
        return managerValue;
    }
}

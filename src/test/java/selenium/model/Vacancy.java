package selenium.model;

import selenium.common.Utils;

public class Vacancy {
    private String jobTitle;
    private String vacancyName;
    private String hiringManager;
    private String noOfPositions;
    private String description;
    private User user;
    private Candidate hiringManagerId;

    public Vacancy() {
        user = new User();
        this.jobTitle = Utils.getProperty("jobTitle");
        this.vacancyName = Utils.getProperty("vacancyName");
        this.hiringManager = String.format("%s %s",user.getUserFirstName(), user.getUserLastName());
        this.noOfPositions = Utils.getProperty("noOfPositions");
        this.description = Utils.getProperty("description");
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public String getNoOfPositions() {
        return noOfPositions;
    }

    public String getDescription() {
        return description;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public Candidate getHiringManagerId() {
        return hiringManagerId;
    }

    public void setHiringManagerId(Candidate hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }
}

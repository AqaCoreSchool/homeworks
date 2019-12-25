package orangetest.sqltask;

public class JobVacancy {
    private String id;
    private String hiringManager;
    private String jobTitle;
    private String vacancyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(String  hiringManager) {
        this.hiringManager = hiringManager;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    @Override
    public String toString() {
        return String.format("Vacancy: id = %s, vacancyName = %s, jobTitle = %s, hiringManager = %s",
                id, vacancyName, jobTitle, hiringManager);
    }

    public String toShortString() {
        return String.format("Vacancy: id = %s, vacancyName = %s, jobTitle = %s",
                id, vacancyName, jobTitle);
    }



}

package data;

public class Vacancy {

    private String vacancyName = "AJunior";
    private String jobTitle = "AQA";
    private String hiringManager = "Oleksandr Yablonskyi";
    private String status = "Active";

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager) {
        this.hiringManager = hiringManager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy1 = (Vacancy) o;

        if (!vacancyName.equals(vacancy1.vacancyName)) return false;
        if (!jobTitle.equals(vacancy1.jobTitle)) return false;
        if (!hiringManager.equals(vacancy1.hiringManager)) return false;
        return status.equals(vacancy1.status);
    }

    @Override
    public int hashCode() {
        int result = vacancyName.hashCode();
        result = 31 * result + jobTitle.hashCode();
        result = 31 * result + hiringManager.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "vacancyName='" + vacancyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", hiringManager='" + hiringManager + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

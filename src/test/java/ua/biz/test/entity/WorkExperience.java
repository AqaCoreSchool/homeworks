package ua.biz.test.entity;

public class WorkExperience {
private int employeeId;
private int id;
private String company;
private String title;

    public WorkExperience(int employeeId, String company, String title) {
        this.employeeId = employeeId;
        this.company = company;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

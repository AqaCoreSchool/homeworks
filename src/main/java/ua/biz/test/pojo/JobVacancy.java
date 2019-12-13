package ua.biz.test.pojo;

public class JobVacancy {
    private String hiringManagerId;
    private String name;

    public void setHiringManagerId(String hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHiringManagerId() {
        return hiringManagerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JobVacancy{ " +
                hiringManagerId + '\t' +
                name +
                '}';
    }
}

package selenium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.javafaker.Faker;
import selenium.common.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkExperience {
    private String seqId;
    private String company;
    private String title;
    private String fromDate;
    private String toDate;
    protected String comment;

    public WorkExperience() {
        this.company = Faker.instance().company().name();
        this.title = Faker.instance().job().title();
        this.fromDate = Utils.getCurrentDate().toString();
        this.toDate = Utils.getCurrentDate().plusYears(2).toString();
        this.comment = Faker.instance().job().keySkills();
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
package selenium.model;

import selenium.common.Utils;

public class Candidate {
    private String candidateFirstName;
    private String candidateLastName;
    private String candidateEmail;
    private String candidateVacancy;
    private String candidateAppliedDate;
    private String candidateContactNo;

    public Candidate() {
        this.candidateFirstName = Utils.getProperty("userFirstName");
        this.candidateLastName = Utils.getProperty("userLastName");
        this.candidateEmail = Utils.getProperty("candidateEmail");
        this.candidateVacancy = Utils.getProperty("vacancyName");
        this.candidateAppliedDate = Utils.getCurrentDate().toString();
        this.candidateContactNo = Utils.getProperty("candidateContactNo");
    }

    public String getCandidateFirstName() {
        return candidateFirstName;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public String getCandidateVacancy() {
        return candidateVacancy;
    }

    public String getCandidateAppliedDate() {
        return candidateAppliedDate;
    }

    public String getCandidateContactNo() {
        return candidateContactNo;
    }
}

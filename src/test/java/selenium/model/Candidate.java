package selenium.model;

import selenium.common.Utils;

import java.util.Objects;

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

    public Candidate(String candidateFirstName, String candidateLastName, String candidateEmail,
                     String candidateVacancy, String candidateAppliedDate, String candidateContactNo) {
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.candidateEmail = candidateEmail;
        this.candidateVacancy = candidateVacancy;
        this.candidateAppliedDate = candidateAppliedDate;
        this.candidateContactNo = candidateContactNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(candidateFirstName, candidate.candidateFirstName) &&
                Objects.equals(candidateLastName, candidate.candidateLastName) &&
                Objects.equals(candidateEmail, candidate.candidateEmail) &&
                Objects.equals(candidateVacancy, candidate.candidateVacancy) &&
                Objects.equals(candidateAppliedDate, candidate.candidateAppliedDate) &&
                Objects.equals(candidateContactNo, candidate.candidateContactNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateFirstName, candidateLastName, candidateEmail, candidateVacancy,
                candidateAppliedDate, candidateContactNo);
    }
}

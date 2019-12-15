package selenium.model;

import selenium.common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidate {
    private String id;
    private String candidateFirstName;
    private String candidateLastName;
    private String candidateEmail;
    private String candidateVacancy;
    private String candidateAppliedDate;
    private String candidateContactNo;
    private List<Vacancy> vacancies = new ArrayList<>();

    public Candidate() {
        this.candidateFirstName = Utils.getProperty("userFirstName");
        this.candidateLastName = Utils.getProperty("userLastName");
        this.candidateEmail = Utils.getProperty("candidateEmail");
        this.candidateVacancy = Utils.getProperty("vacancyName");
        this.candidateAppliedDate = Utils.getCurrentDate().toString();
        this.candidateContactNo = Utils.getProperty("candidateContactNo");
    }

    public Candidate(String id) {
        this.id = id;
    }

    public Candidate(String id, String candidateFirstName, String candidateLastName, List<Vacancy> vacancies) {
        this.id = id;
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.vacancies = vacancies;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Vacancy vacancy) {
        this.vacancies.add(vacancy);
    }

    public void setCandidateFirstName(String candidateFirstName) {
        this.candidateFirstName = candidateFirstName;
    }

    public void setCandidateLastName(String candidateLastName) {
        this.candidateLastName = candidateLastName;
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

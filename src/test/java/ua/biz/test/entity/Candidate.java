package ua.biz.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.Serializable;
import java.util.Objects;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;

    private Vacancy vacancy;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, String email, Vacancy vacancy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.vacancy = vacancy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return String.format("%s %s",firstName,lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(firstName, candidate.firstName) &&
                Objects.equals(lastName, candidate.lastName) &&
                Objects.equals(email, candidate.email) &&
                Objects.equals(vacancy, candidate.vacancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, vacancy);
    }
}

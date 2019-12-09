package com.company.vTests.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String candidateVacancy;
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.now();
    private String candidateApplicationDate = localDate.format(date);


    public Candidate(String firstName,
                     String lastName,
//                     String email,
                     String contactNo
//                     String candidateVacancy,
//                     String candidateApplicationDate
                     ) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.email = email;
        this.contactNo = contactNo;
//        this.candidateVacancy = candidateVacancy;
//        this.candidateApplicationDate = candidateApplicationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getCandidateVacancy() {
        return candidateVacancy;
    }

    public String getCandidateApplicationDate() {
        return candidateApplicationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;
        if (!firstName.equals(candidate.firstName)) return false;
        if (!lastName.equals(candidate.lastName)) return false;
        if (!email.equals(candidate.email)) return false;
        if (!candidateApplicationDate.equals(candidate.candidateApplicationDate)) return false;
        return candidateVacancy.equals(candidate.candidateVacancy);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, candidateVacancy,
                candidateApplicationDate);
    }

}

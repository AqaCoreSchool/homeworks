package com.company.vTests.data;

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
                     String contactNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;
        if (!firstName.equals(candidate.firstName)) return false;
        if (!lastName.equals(candidate.lastName)) return false;
        return contactNo.equals(candidate.contactNo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, contactNo);
    }

}

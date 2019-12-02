package ua.biz.test.entity;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private Vacancy vacancy;

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
}

package data;



public class Candidate {

    private String firstName = "Andrii";
    private String lastName = "Shtyiuk";
    private String email = "andrii.shtyiuk@gmail.com";
    private String phoneNumber = "0686478967";
    private String vacancy = "Junior";


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (!firstName.equals(candidate.firstName)) return false;
        if (!lastName.equals(candidate.lastName)) return false;
        if (!email.equals(candidate.email)) return false;
        if (!phoneNumber.equals(candidate.phoneNumber)) return false;
        return vacancy.equals(candidate.vacancy);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + vacancy.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vacancy='" + vacancy + '\'' +
                '}';
    }
}

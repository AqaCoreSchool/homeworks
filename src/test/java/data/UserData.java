package data;

public class UserData {
    private String firstName;
    private String lastName;
    private int maritalStatusOption;
    private String nationality;
    private String birthdayDate;

    public UserData() {
        this.firstName = "Nazariy";
        this.lastName = "Kushnir";
        this.maritalStatusOption = 1;
        this.nationality = "185";
        this.birthdayDate = "1989-10-23";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMaritalStatus() {
        return maritalStatusOption;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }
}

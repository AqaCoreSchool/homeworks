package library;

import library.enumeration.ProfileStatus;
import library.model.Person;

public abstract class Profile {
    private String id;
    private Person person;
    private ProfileStatus profileStatus;

    public Profile() {

    }

    public Profile(String id, Person person, ProfileStatus profileStatus) {
        this.id = id;
        this.person = person;
        this.profileStatus = profileStatus;
    }

    public Profile(String id, Person person) {
        this.id = id;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(ProfileStatus profileStatus) {
        this.profileStatus = profileStatus;
    }
}

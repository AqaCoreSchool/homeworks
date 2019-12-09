package data;

public class JobCandidate {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private CandidateAttachment attachment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            this.email = "";
        }
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        if (contactNumber == null) {
            this.contactNumber = "";
        }
        this.contactNumber = contactNumber;
    }

    public CandidateAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(CandidateAttachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return String.format("Candidate [id=%s, first_name=%s, last_name=%s, email=%s, contact_number=%s, " +
                "attachment_name=%s, attachment_type=%s]",
                id, firstName, lastName, email, contactNumber, attachment.getFileName(), attachment.getFileType());
    }
}

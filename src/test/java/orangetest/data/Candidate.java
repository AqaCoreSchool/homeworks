package orangetest.data;

import java.util.Objects;

public class Candidate {
    private String candidateFirstName = "Mariana";
    private String candidateLastName = "Mykytovych";
    private String candidateMiddleName = "Romanivna";
    private String candidateEmail = "my_e-mail@gmail.com";

    public Candidate() {
    }

    public Candidate(String candidateFirstName, String candidateLastName, String candidateMiddleName, String candidateEmail) {
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.candidateMiddleName = candidateMiddleName;
        this.candidateEmail = candidateEmail;
    }

    public String getCandidateFirstName() {
        return candidateFirstName;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public String getCandidateMiddleName() {
        return candidateMiddleName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return this.candidateFirstName.equals(candidate.candidateFirstName) &&
                this.candidateLastName.equals(candidate.candidateLastName) &&
                this.candidateMiddleName.equals(candidate.candidateMiddleName) &&
                this.candidateEmail.equals(candidate.candidateEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateFirstName, candidateLastName, candidateMiddleName, candidateEmail);
    }
}

package testpackage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vacancy {

    @JsonProperty("HiringManager")
    private String hiringManagerID;

    private String name;

    @JsonProperty("Vacancy")
    private String vacancy;

    @JsonProperty("JobTitle")
    private String jobTitle;

    @JsonProperty("Status")
    private String status;

    Candidate candidate;

    @Override
    public String toString() {
        return String.format("Vacancy [hiring_manager_id: %s| name: %s|\t emp_number: %s| first_name: %s| last_name: %s]",
                hiringManagerID, name, candidate.getEmpNumber(), candidate.getFirstName(), candidate.getLastName());
    }
}

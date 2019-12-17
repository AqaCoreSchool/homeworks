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
    private String hiringManager ;

    @JsonProperty("Vacancy")
    private String vacancy;

    @JsonProperty("JobTitle")
    private String jobTitle;

    @JsonProperty("Status")
    private String status;

    @Override
    public String toString() {
        return "Vacancy[HiringManager:" + hiringManager + "Vacancy:" + vacancy + "JobTitle:" + jobTitle +
                ", Status: " + status + "]";
    }
}

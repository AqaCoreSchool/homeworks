package testpackage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    private int employeeId;

    private int id;

    private String company;

    private String title;

}

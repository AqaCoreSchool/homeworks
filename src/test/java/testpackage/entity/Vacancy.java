package testpackage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vacancy {

    private String hiringManager ;

    private String vacancy;

    private String jobTitle;

    private String status;
}

package lombok.random;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter @Setter
public class VacancyRand {

    private String vacancy;
    private String jobTitle;
    private String hiringManager ;
    private String status;
}

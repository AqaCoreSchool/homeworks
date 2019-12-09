package lombok.random;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter @Setter
public class CandidateRand {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String vacancy;
}

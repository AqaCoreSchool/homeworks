package lombok.factory;

import com.github.javafaker.Faker;
import lombok.random.CandidateRand;


public class CandidateRandFactory {

    private Faker faker = new Faker();

    public CandidateRand createRandomCandidate(){
        return CandidateRand.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().cellPhone())
                .vacancy(faker.job().position())
                .build();
    }
}

package testpackage.factory;

import com.github.javafaker.Faker;
import testpackage.entity.Candidate;

import java.io.File;
import java.time.LocalDate;

public class CandidateFactory {

    private Faker faker;

    public Candidate defaultCandidate(){
       return Candidate.builder()
               .firstName("Danylo")
               .middleName("Alexandrovich")
               .lastName("Pazykov")
               .email("pazikovd@gmail.com")
               .date(LocalDate.now().toString())
               .phoneNumber("+380506442833")
               .vacancy("AQA Junior")
               .resume("C:"+ File.separator+"Users"+File.separator+"Daniel"
                       +File.separator+"Desktop"+File.separator+"Pazykov Danylo.pdf")
               .build();
    }

    public Candidate randomCandidate(){
        return Candidate.builder()
                .firstName(faker.name().firstName())
                .middleName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.address().firstName())
                .date(LocalDate.now().toString())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .vacancy(faker.job().position())
                .resume(faker.file().fileName())
                .build();
    }
}

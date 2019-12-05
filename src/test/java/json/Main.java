package json;

import data.Candidate;
import data.Vacancy;

public class Main {

    public static void main(String[] args) {
        Candidate firstCandidate = new Candidate();
        String jsonString = "{\"firstName\": \"Andrii\", \"lastName\": \"Shtyiuk\"," +
                "\"email\": \"andrii.shtyiuk@gmail.com\", " +
                "\"phoneNumber\": \"0686478967\", \"vacancy\": \"Junior\"}";
        JsonParser jsonParser = new JsonParser();
        Candidate secondCandidate = jsonParser.getCandidate(jsonString);
        System.out.println(firstCandidate.equals(secondCandidate));

        Vacancy firstVacancy = new Vacancy();
        String jsonString2 = "{\"vacancyName\": \"Junior\", \"jobTitle\": \"AQA\"," +
                "\"hiringManager\": \"Oleksandr Yablonskyi\", " +
                "\"status\": \"Active\"}";
        JsonParser jsonParser2 = new JsonParser();
        Vacancy secondVacancy = jsonParser2.getVacancy(jsonString2);
        System.out.println(firstVacancy.equals(secondVacancy));


    }
}

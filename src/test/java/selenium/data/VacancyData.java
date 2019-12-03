package selenium.data;

public class VacancyData {
    public static final String JOB_TITLE = "AQA";
    public static final String VACANCY_NAME = "Quality Assurance";
    public static final String HIRING_MANAGER = String.format("%s %s", UserData.USER_NAME, UserData.USER_LASTNAME);
    public static final String POSITIONS_NUMBER = "2";
    public static final String DESCRIPTION = "Vacancy Description";
    public static final boolean ACTIVE = true;
    public static final boolean PUBLISHED_IN_FEED = true;

    private VacancyData() {
    }
}


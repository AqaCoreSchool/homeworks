package database.interfaces;

import selenium.model.Candidate;
import java.util.List;

public interface EmployeeDao {
    List<Candidate> getEmployeesByJobVacancyName (String jobVacancyName);
}

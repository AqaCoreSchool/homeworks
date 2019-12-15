package database.interfaces;

import selenium.model.Candidate;
import java.util.List;

public interface EmployeeDAO {
    List<Candidate> getEmployeesByJobVacancyName (String jobVacancyName);
}

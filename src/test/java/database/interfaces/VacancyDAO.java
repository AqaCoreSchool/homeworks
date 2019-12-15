package database.interfaces;

import selenium.model.Vacancy;
import java.util.List;

public interface VacancyDAO {
    List<Vacancy> getVacanciesByEmployeeName(String name, String lastName);
}

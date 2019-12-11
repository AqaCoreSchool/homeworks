package database.interfaces;

import selenium.model.Vacancy;

import java.util.List;

public interface VacancyDao {
    List<Vacancy> getVacanciesByEmployeeName(String name, String lastName);
}

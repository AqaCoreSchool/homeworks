package data;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLData {
    private String emp_number;
    private String emp_firstname;
    private String emp_lastname;
    private List<JobVacancySQLData> vacancies;

    public EmployeeSQLData() {
        this.vacancies = new ArrayList<>();
    }

    public String getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(String emp_number) {
        this.emp_number = emp_number;
    }

    public String getEmp_firstname() {
        return emp_firstname;
    }

    public void setEmp_firstname(String emp_firstname) {
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public List<JobVacancySQLData> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<JobVacancySQLData> vacancies) {
        this.vacancies = vacancies;
    }

    public void addVacancy(JobVacancySQLData vacancy) {
        this.vacancies.add(vacancy);
    }


    @Override
    public String toString() {
        return "EmployeeSQLData{" +
                "emp_number='" + emp_number + '\'' +
                ", emp_firstname='" + emp_firstname + '\'' +
                ", emp_lastname='" + emp_lastname + '\'' +
                ", vacancies=" + vacancies +
                '}';
    }
}

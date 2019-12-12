package sql.data;

import java.util.List;

public class Employee {
    private String empNumber;
    private String empFirstName;
    private String empLastName;
    private List<JobVacancy> vacancies;

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public List<JobVacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<JobVacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empNumber != null ? !empNumber.equals(employee.empNumber) : employee.empNumber != null) return false;
        if (empFirstName != null ? !empFirstName.equals(employee.empFirstName) : employee.empFirstName != null)
            return false;
        if (empLastName != null ? !empLastName.equals(employee.empLastName) : employee.empLastName != null)
            return false;
        return vacancies != null ? vacancies.equals(employee.vacancies) : employee.vacancies == null;
    }

    @Override
    public int hashCode() {
        int result = empNumber != null ? empNumber.hashCode() : 0;
        result = 31 * result + (empFirstName != null ? empFirstName.hashCode() : 0);
        result = 31 * result + (empLastName != null ? empLastName.hashCode() : 0);
        result = 31 * result + (vacancies != null ? vacancies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNumber='" + empNumber + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", vacancies=" + vacancies +
                '}';
    }
}

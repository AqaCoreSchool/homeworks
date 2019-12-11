package orangetest.sqltask;

import java.util.List;

public class Employee {
    private String empNumber;
    private String empFirstName;
    private String empLastName;
    private List<JobVacancy> vacancyList;

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

    public List<JobVacancy> getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List<JobVacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }


    @Override
    public String toString() {
        return String.format("Employee: empNumber = %s, empFirstName = %s, empLastName = %s",
                empNumber, empFirstName, empLastName)+ "\n      " + SqlDataProvider.printVacancyListToString(vacancyList);
    }

    public String fullName() {
        return String.format("empFirstName = %s, empLastName = %s", empFirstName, empLastName);
    }
}
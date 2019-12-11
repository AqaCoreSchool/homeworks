package ua.biz.test.enums;

public enum TableName {
    EMPLOYEE_TABLE("hs_hr_employee"),
    VACANCY_TABLE("ohrm_job_vacancy");

    private String name;

    TableName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

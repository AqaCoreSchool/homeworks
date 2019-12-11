package ua.biz.test.enums;

public enum VacancyColumnsName {
    ID("id"),
    HIRING_MANAGER_ID("hiring_manager_id"),
    NAME("name");

    private String name;

    VacancyColumnsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

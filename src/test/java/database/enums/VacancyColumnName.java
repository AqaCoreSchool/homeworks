package database.enums;

public enum VacancyColumnName {
    MANAGER_ID("hiring_manager_id"),
    NAME("name");

    private final String name;

    VacancyColumnName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

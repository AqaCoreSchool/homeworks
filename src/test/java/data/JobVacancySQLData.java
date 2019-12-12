package data;

public class JobVacancySQLData {
    private String hiring_manager_id;
    private String name;

    public String getHiring_manager_id() {
        return hiring_manager_id;
    }

    public void setHiring_manager_id(String hiring_manager_id) {
        this.hiring_manager_id = hiring_manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobVacancySQLData{" +
                "hiring_manager_id='" + hiring_manager_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

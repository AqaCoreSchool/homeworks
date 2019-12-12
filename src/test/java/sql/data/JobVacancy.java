package sql.data;

public class JobVacancy {
    private String name;
    private String hiringManagerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHiringManagerId() {
        return hiringManagerId;
    }

    public void setHiringManagerId(String hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobVacancy vacancy = (JobVacancy) o;

        if (name != null ? !name.equals(vacancy.name) : vacancy.name != null) return false;
        return hiringManagerId != null ? hiringManagerId.equals(vacancy.hiringManagerId) : vacancy.hiringManagerId == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (hiringManagerId != null ? hiringManagerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JobVacancy{" +
                "name='" + name + '\'' +
                ", hiringManagerId='" + hiringManagerId + '\'' +
                '}';
    }
}

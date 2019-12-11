package ua.biz.test.entity;

import java.util.Objects;

public class Vacancy{

    private String name;
    private Employee hiringManager;
    private int nubmerOfPositions;

    private boolean isActive;

    public Vacancy() { }

    public Vacancy(String name, Employee hiringManager) {
        this.name = name;
        this.hiringManager = hiringManager;
    }

    public Vacancy(String name, Employee hiringManager, int nubmerOfPositions, boolean isActive) {
        this.name = name;
        this.hiringManager = hiringManager;
        this.nubmerOfPositions = nubmerOfPositions;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHiringManager(Employee hiringManager) {
        this.hiringManager = hiringManager;
    }

    public Employee getHiringManager() {
        return hiringManager;
    }

    public int getNubmerOfPositions() {
        return nubmerOfPositions;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return nubmerOfPositions == vacancy.nubmerOfPositions &&
                isActive == vacancy.isActive &&
                Objects.equals(name, vacancy.name) &&
                Objects.equals(hiringManager, vacancy.hiringManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hiringManager, nubmerOfPositions, isActive);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "name='" + name + '\'' +
                ", hiringManager=" + hiringManager +
                ", nubmerOfPositions=" + nubmerOfPositions +
                ", isActive=" + isActive +
                '}';
    }
}

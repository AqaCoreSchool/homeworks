package ua.biz.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class Vacancy{

    private String name;
    private String hiringManagerName;
    private int nubmerOfPositions;

    private boolean isActive;

    public Vacancy() { }

    public Vacancy(String name, String hiringManagerName) {
        this.name = name;
        this.hiringManagerName = hiringManagerName;
    }

    public Vacancy(String name, String hiringManagerName, int nubmerOfPositions, boolean isActive) {
        this.name = name;
        this.hiringManagerName = hiringManagerName;
        this.nubmerOfPositions = nubmerOfPositions;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHiringManagerName() {
        return hiringManagerName;
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
                Objects.equals(hiringManagerName, vacancy.hiringManagerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hiringManagerName, nubmerOfPositions, isActive);
    }
}

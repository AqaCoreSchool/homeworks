package ua.biz.test.entity;

public class Vacancy {
    private String name;
    private String hiringManagerName;
    private int nubmerOfPositions;
    private boolean isActive;

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
}

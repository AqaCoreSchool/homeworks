package com.burgerking;

public class CreditCard {
    private String name;
    private Double ballance;

    public CreditCard(String name, Double ballance) {
        this.name = name;
        this.ballance = ballance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBallance() {
        return ballance;
    }

    public void setBallance(Double ballance) {
        this.ballance = ballance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", ballance=" + ballance +
                '}';
    }
}

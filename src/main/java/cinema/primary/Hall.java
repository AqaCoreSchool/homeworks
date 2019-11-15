package cinema.primary;

import cinema.enums.HallType;

public class Hall {
    private int number;
    private HallType type;
    private int capasity;
    private double screenSize;

    public Hall(int number, HallType type, int capasity, double screenSize) {
        this.number = number;
        this.type = type;
        this.capasity = capasity;
        this.screenSize = screenSize;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public HallType getType() {
        return type;
    }

    public void setType(HallType type) {
        this.type = type;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "number=" + number +
                ", type=" + type +
                ", capasity=" + capasity +
                ", screenSize=" + screenSize +
                '}';
    }
}

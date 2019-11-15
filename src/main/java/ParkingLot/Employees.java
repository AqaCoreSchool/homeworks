package ParkingLot;

public abstract class Employees {
    private String name;
    private String position;
    private int workHours;
    private int ratePerHour;


    public Employees() {
    }

    public Employees(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    abstract void standard();

    public int getSalary() {
        return this.ratePerHour * this.workHours;
    }

    public void setStaff(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    public void setRatePerHour(int rate) {
        this.ratePerHour = rate;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWorkHours() {
        return this.workHours;
    }

    @Override
    public String toString() {
        return this.name + " " + position + ". Salary: " + this.getSalary();
    }


}

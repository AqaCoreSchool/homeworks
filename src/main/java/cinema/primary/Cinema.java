package cinema.primary;


public class Cinema {
    private String name;
    private String address;
    private int numberOfEmployees;

    public Cinema(String name, String address, int numberOfEmployees) {
        this.name = name;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }
}

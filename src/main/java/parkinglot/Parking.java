package parkinglot;

import java.util.*;

public class Parking {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Map<String, Vehicle> mapOfVehicles = new HashMap<String, Vehicle>() {
            {
                put("first", new Lorry("man - lorry", 6, 1, "BC1256TH", 10, "Ivan"));
                put("second", new SportCar("ferrari - sportar", 4, 5, "AK2569OH", 54, "Nazar"));
            }
        };

        vehicles.add(new Lorry("man - lorry", 6, 1, "BC1256TH", 10, "Ivan"));
        vehicles.add(new Lorry("volvo - lorry", 10, 2, "AA2566AO", 200, "Ivan"));
        vehicles.add(new Lorry("kamaz - lorry", 16, 3, "AB2525CH", 8, "Fedir"));
        vehicles.add(new Bike("kawasaki - bike", 2, 4, "AA4585TH", 6, "Vasyl"));
        vehicles.add(new SportCar("ferrari - sportar", 4, 5, "AK2569OH", 54, "Nazar"));
        vehicles.add(new SportCar("lamborghini - sportcar", 4, 6, "BC2569TH", 12, "Stepan"));
        vehicles.add(new Bike("BMW - bike", 2, 7, "OP4585TH", 12, "Fedir"));
        vehicles.add(new Bike("Yamaha - bike", 2, 8, "PO4585TH", 56, "Siroga"));
        vehicles.add(new Bike("MT - bike", 2, 9, "AM4585HH", 96, "Natalya"));


        getVehiclesAtTheParking(vehicles); //1
        System.out.println();
        getVehiclesFilteredByType(vehicles, "Lorry"); //2
        System.out.println();
        sortAccordingToDurationStaying(vehicles); //3
        System.out.println();
        checkIfAtLeastOneFromLviv(vehicles);  //4
        System.out.println();
        checkOwner(vehicles, "Ivan"); //5
        System.out.println();
        getVehiclesFilteredByType(vehicles, "motorcycle"); //6
        System.out.println();
        sortCarsByRegistrationNumber(vehicles);


    }

    public static void getVehiclesAtTheParking(List<Vehicle> veh) {
        for (Vehicle v : veh)
            System.out.print(v.getStateNumber() + ", ");
    }

    public static void getVehiclesFilteredByType(List<Vehicle> veh, String type) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (int i = 0; i < veh.size(); i++) {
            if ((veh.get(i).getClass().getName()).endsWith(type)) {
                filteredVehicles.add(veh.get(i));
            }
        }
        if (filteredVehicles.size() == 0) {
            System.out.println("vehicles with type : " + type + " enabled");
        }
    }

    static class SortByDurationStaying implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStayOnParking() - b.getStayOnParking();
        }
    }

    public static void sortAccordingToDurationStaying(List<Vehicle> veh) {
        Collections.sort(veh, new SortByDurationStaying());
        for (Vehicle v : veh)
            System.out.print(v.getStayOnParking() + ", ");
    }

    public static void checkIfAtLeastOneFromLviv(List<Vehicle> veh) {
        for (Vehicle v : veh) {
            if (v.getStateNumber().startsWith("BC")) {
                System.out.println("at least one Vehicle from Lviv exist");
                break;
            }
        }

    }

    public static void checkOwner(List<Vehicle> veh, String owner) {
        for (Vehicle v : veh) {
            if (v.getOwner().equals(owner)) {
                System.out.println("owner " + v.getForm() + " " + v.getStateNumber() + " " + owner);
            }
        }
    }

    public static void sortCarsByRegistrationNumber(List<Vehicle> veh) {
        Collections.sort(veh, sortByRegistrationNumber);
        for (Vehicle v : veh)
            System.out.print(v.getStateNumber() + ", ");
    }


    static Comparator<Vehicle> sortByRegistrationNumber = new Comparator<Vehicle>() {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStateNumber().compareTo(b.getStateNumber());
        }


    };

}

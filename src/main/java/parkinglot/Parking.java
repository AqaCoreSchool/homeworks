package parkinglot;

import java.util.*;

import static java.lang.System.*;

public class Parking {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();


        vehicles.add(new Lorry("man - lorry", 6, 1, "BC1256TH", 10, "Ivan"));
        vehicles.add(new Lorry("volvo - lorry", 10, 2, "AA2566AO", 200, "Ivan"));
        vehicles.add(new Lorry("kamaz - lorry", 16, 3, "AB2525CH", 8, "Fedir"));
        vehicles.add(new Bike("kawasaki - bike", 2, 4, "AA4585TH", 6, "Vasyl"));
        vehicles.add(new SportCar("ferrari - sportar", 4, 5, "AK2569OH", 54, "Nazar"));
        vehicles.add(new SportCar("lamborghini - sportcar", 4, 6, "BC2569TH", 12, "Stepan"));
        vehicles.add(new Bike("BMW - bike", 2, 7, "OP4585TH", 12, "Fedir"));
        vehicles.add(new Bike("Yamaha - bike", 2, 8, "PO4585TH", 56, "Siroga"));
        vehicles.add(new Bike("MT - bike", 2, 9, "AM4585HH", 96, "Natalya"));


        getVehiclesAtTheParking(vehicles); //1.  list of parking lot
        out.println();
        getVehiclesFilteredByType(vehicles, "Lorry"); //2. create new list, filtered by type "Lorry"
        out.println();
        sortAccordingToDurationStaying(vehicles); //3. Sorting according to duration staying on parking
        out.println();
        checkIfAtLeastOneFromLviv(vehicles);  //4. check at least one vehicle from Lviv
        out.println();
        checkOwner(vehicles, "Ivan"); //5. Sort all "Ivans" vecicles
        out.println();
        getVehiclesFilteredByType(vehicles, "motorcycle"); //6 Check none "motorcycle" vehicles
        out.println();
        sortCarsByRegistrationNumber(vehicles); //7. Sort alphabetically by registration num.


    }

    private static void getVehiclesAtTheParking(List<Vehicle> veh) {
        for (Vehicle v : veh)
            out.print(v.getStateNumber() + ", ");
    }

    private static void getVehiclesFilteredByType(List<Vehicle> veh, String type) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : veh) {
            if ((vehicle.getForm().equalsIgnoreCase(type))) {
                filteredVehicles.add(vehicle);
            }
        }

    }

    static class SortByDurationStaying implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStayOnParking() - b.getStayOnParking();
        }
    }

    private static void sortAccordingToDurationStaying(List<Vehicle> veh) {
        Collections.sort(veh, new SortByDurationStaying());
        for (Vehicle v : veh)
            out.print(v.getStayOnParking() + ", ");
    }

    private static void checkIfAtLeastOneFromLviv(List<Vehicle> veh) {
        for (Vehicle v : veh) {
            if (v.getStateNumber().startsWith("BC")) {
                out.println("at least one Vehicle from Lviv exist");
                break;
            }
        }

    }

    private static void checkOwner(List<Vehicle> veh, String owner) {
        for (Vehicle v : veh) {
            if (v.getOwner().equals(owner)) {
                out.println("owner " + v.getForm() + " " + v.getStateNumber() + " " + owner);
            }
        }
    }

    private static void sortCarsByRegistrationNumber(List<Vehicle> veh) {
        Collections.sort(veh, sortByRegistrationNumber);
        Set<Vehicle> vehicleSet = new HashSet<>();
        vehicleSet.addAll(veh);
        for (Vehicle v : vehicleSet) out.print(v.getStateNumber() + ", ");
    }


    static Comparator<Vehicle> sortByRegistrationNumber = new Comparator<Vehicle>() {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStateNumber().compareTo(b.getStateNumber());
        }


    };

}

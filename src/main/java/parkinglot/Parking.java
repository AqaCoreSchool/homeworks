package parkinglot;

import parkinglot.exception.VehicleNotFoundException;
import parkinglot.vehicles.Bike;
import parkinglot.vehicles.Lorry;
import parkinglot.vehicles.SportCar;
import parkinglot.vehicles.Vehicle;

import java.util.*;

import static java.lang.System.*;

public class Parking {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Parking parking = new Parking();


//        vehicles.add(new Lorry("man - lorry", 6, 1, "BC1256TH", 10, "Ivan"));
//        vehicles.add(new Lorry("volvo - lorry", 10, 2, "AA2566AO", 200, "Ivan"));
//        vehicles.add(new Lorry("kamaz - lorry", 16, 3, "AB2525CH", 8, "Fedir"));
//        vehicles.add(new Bike("kawasaki - bike", 2, 4, "AA4585TH", 6, "Vasyl"));
//        vehicles.add(new SportCar("ferrari - sportar", 4, 5, "AK2569OH", 54, "Nazar"));
//        vehicles.add(new SportCar("lamborghini - sportcar", 4, 6, "BC2569TH", 12, "Stepan"));
//        vehicles.add(new Bike("BMW - bike", 2, 7, "OP4585TH", 12, "Fedir"));
//        vehicles.add(new Bike("Yamaha - bike", 2, 8, "PO4585TH", 56, "Siroga"));
//        vehicles.add(new Bike("MT - bike", 2, 9, "AM4585HH", 96, "Natalya"));

        parking.verifyVehiclesListNotEmpty(vehicles); // 1. verify list of vehicles is not empty
        out.println();
        parking.getVehiclesFormAtTheParking(vehicles); // 2. get list of vechicles
        out.println();
        parking.getVehiclesFilteredByType(vehicles, "Lorry");//3. create new list, filtered by type "Lorry"
        out.println();
        parking.sortAccordingToDurationStaying(vehicles); //4. Sorting according to duration staying on parking
        out.println();
        parking.checkIfAtLeastOneFromLviv(vehicles);  //5. check at least one vehicle from Lviv
        out.println();
        parking.getListOfCarsByOwner(vehicles, "Ivan"); //6. Return all "Ivans" vecicles
        out.println();
        parking.getVehiclesFilteredByType(vehicles, "motorcycle"); //7 Check none "motorcycle" vehicles
        out.println();
        parking.sortCarsByRegistrationNumber(vehicles); //8. Sort alphabetically by registration num.
    }

    private List<String> getVehiclesFormAtTheParking(List<Vehicle> veh) {
        List<String> formOfVehiclesOnParking = new ArrayList<>();
        for (Vehicle vehicle : veh) {
            formOfVehiclesOnParking.add(vehicle.getForm() + " with number: " + vehicle.getStateNumber());
        }
        return formOfVehiclesOnParking;
    }

    private List<Vehicle> getVehiclesFilteredByType(List<Vehicle> veh, String type) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : veh) {
            if ((vehicle.getForm().equalsIgnoreCase(type))) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;

    }

    static class SortByDurationStaying implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStayOnParking() - b.getStayOnParking();
        }
    }

    private List<Vehicle> sortAccordingToDurationStaying(List<Vehicle> veh) {
        List<Vehicle> sortedVehicles = new ArrayList<>();
        Collections.sort(veh, new SortByDurationStaying());
        for (Vehicle v : veh)
            sortedVehicles.add(v);
        return sortedVehicles;
    }

    private boolean checkIfAtLeastOneFromLviv(List<Vehicle> veh) {
        for (Vehicle v : veh) {
            if (v.getStateNumber().startsWith("BC")) {
                out.println("at least one Vehicle from Lviv exist");
                return true;
            }
        }
        return false;
    }

    private List<Vehicle> getListOfCarsByOwner(List<Vehicle> veh, String owner) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle v : veh) {
            if (v.getOwner().equals(owner)) {
                filteredVehicles.add(v);
            }
            out.println("owner " + v.getForm() + " " + v.getStateNumber() + " " + owner);
        }
        return filteredVehicles;
    }


    private Set<String> sortCarsByRegistrationNumber(List<Vehicle> veh) {
        Collections.sort(veh, sortByRegistrationNumber);
        Set<String> vehicleSet = new HashSet<>();
        vehicleSet.add(veh.get(1).getStateNumber());
        return vehicleSet;
    }

    static Comparator<Vehicle> sortByRegistrationNumber = new Comparator<Vehicle>() {

        @Override
        public int compare(Vehicle a, Vehicle b) {
            return a.getStateNumber().compareTo(b.getStateNumber());
        }

    };

    private void verifyVehiclesListNotEmpty(List<Vehicle> list) {
        if (list.isEmpty()) {
            throw new VehicleNotFoundException("List of vehicles is empty, nothing to execute");
        }
    }

}

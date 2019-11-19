package parking;

import java.util.Scanner;

import static parking.VehicleParking.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AbstractEmployee securityStaff1 = new SecurityStaff();
        securityStaff1.setStaff("Ivan", 250);
        System.out.println(securityStaff1.toString());
        AbstractEmployee admin1 = new Admin("Petro", 80);
        System.out.println(admin1.toString());

        AbstractVehicle truck1 = new Truck("Ivan Franko", "АА 6789 КА");
        VehicleParking.waitConsole();
        AbstractVehicle car2 = new Car("Taras Shevchenko", "АВ 3454 КВ");
        VehicleParking.waitConsole();
        AbstractVehicle truck3 = new Truck("Lesya Ukrainka", "АТ 1122211 ТИ");
        VehicleParking.waitConsole();
        AbstractVehicle car4 = new Car("Grigoriy Scovoroda", "ВСC 2222 АВ");
        VehicleParking.waitConsole();
        AbstractVehicle truck5 = new Truck("Ostap Vyshny", "ВВ 3333 АК");
        VehicleParking.waitConsole();
        AbstractVehicle car6 = new Car("", "ВІ 44444 КЛ");
        VehicleParking.waitConsole();
        AbstractVehicle car7 = new Car("Ivan Petrenko", "АА 5555 ОП");
        VehicleParking.waitConsole();
        AbstractVehicle truck8 = new Truck("Stephen King", "АА 5556 ТИ");
        AbstractVehicle truck9 = new Truck("George Martin", "АППА 5556 ТИ");
        AbstractVehicle car10 = new Car("Joanne Rowling", "АА 5556 ТИ");
        AbstractVehicle truck11 = new Truck();
        AbstractVehicle truck12 = new Truck("Ostap Ivanov", "АВ 5556 ТИ");
        AbstractVehicle truck13 = new Truck("Tim Barton", "АА 5586 ТИ");
        AbstractVehicle truck14 = new Truck("Ivan Ivanov", "АА 5556 ТИ");
        AbstractVehicle truck15 = new Truck("Ivan Ivanov", "А");

        System.out.println("\nResults of method CheckIn/CheckOut\n");
        truck11.checkIn(truck1);
        car2.checkIn(car2);
        truck3.checkIn(truck3);
        car4.checkIn(car4);
        truck5.checkIn(truck5);
        car6.checkIn(car6);
        car7.checkIn(car7);
        truck8.checkIn(truck8);
        truck9.checkIn(truck9);
        car10.checkIn(car10);
        truck11.checkIn(truck11);
        truck12.checkIn(truck12);

        // Task #1 Add possibility for user to retrieve list of vehicles on a parking lot
        System.out.println("\nResults of method which prints all vehicles\n");
        VehicleParking.printList(vehicleList);

        //Task #2 Add possibility for user to retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)
        System.out.println("\nMethod which prints all vehicles, which type are ... Please enter type: Car or Truck\n");
        String typeForSearch = scanner.nextLine();
        filterByType(typeForSearch);

        // Task #3 Sort vehicles list according to duration it is staying on a parking lot
        System.out.println("\nRevers sorting by durations\n");
        sortByDurations();

        // Task #4
        System.out.println("\nMethod which, checking if at least one vehicle in list corresponds to some search criteria.\n (e.g. vehicle number starts with ‘BC’))\n");
        String numberForSearch = scanner.nextLine();
        System.out.println(isNumberExist(numberForSearch));

        // Task #5 Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)
        System.out.println("\nCheck if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)\n");
        String ownerForSearch = scanner.nextLine();
        System.out.println(isAllOwners(ownerForSearch));

        // Task #6
        System.out.println("\nCheck if none of the vehicles from list corresponds to some search criteria (e.g. vehicle type is motorcycle)\n");
        typeForSearch = scanner.nextLine();
        System.out.println(isAllTypes(typeForSearch));

        // Task #7
        System.out.println("\nVehicle list, with unique numbers, sorted alphabetically\n"); // Task #7
        System.out.println(getCarByUniqueNumber());

        // print list with tickets, with formatted datetime
        System.out.println("\nTickets list\n");
        VehicleParking.printList(ticketsList);
    }
}

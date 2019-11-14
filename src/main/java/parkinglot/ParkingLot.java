package parkinglot;

public class ParkingLot {

    private String name;
    private String address;
    private int capacity;

    private int freeSpots = 0;

    private ParkingSpot[] parkingSpots;
    private ParkingTicket[] parkingTickets;
    private Vehicle[] vehicles;


    // initiate Parking Lot
    ParkingLot(int capacity) {

        //System.out.println("Initialization of new parking lot with capacity: " + capacity);
        this.capacity = capacity;

        parkingSpots = new ParkingSpot[capacity];
        parkingTickets = new ParkingTicket[capacity];
        vehicles = new Vehicle[capacity];

        for (int i = 0; i < capacity; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1);
            freeSpots++;
        }
    }

    private boolean isFull () {
        if (freeSpots == 0) {
            return true;
        }
        return false;
    }

    public String addVehicleToParkingLot(Vehicle vehicle) {

        if (isFull()) {
            return "Sorry, but parking spot is full. Try again later.";
        } else {
            freeSpots--;

            int freeParkingSpot = checkFirstFreeParkingSpot();
            parkingSpots[freeParkingSpot].addVehicle(vehicle);

            parkingTickets[freeParkingSpot] = new ParkingTicket();

            this.vehicles[freeParkingSpot] = vehicle;

            return  display("Add", freeParkingSpot);
        }
    }

    public String removeVehicleFromParkingLot(Vehicle vehicle, String parkingTicketNumber) {
        freeSpots++;
        int spot = -1;

        for (int i = 0; i < capacity; i++) {
            if (parkingTickets[i].getParkingTicketNumber() == parkingTicketNumber) {
                spot = i;
                parkingSpots[spot].removeVehicle(vehicle);
                parkingTickets[spot].setPaymentStatus(PaymentStatus.PAYED.toString());
                parkingTickets[spot].setExitTime();
                break;
            }
        }
        return  display("Remove", spot);
    }

    private int checkFirstFreeParkingSpot() {
        for (int i = 0; i < capacity; i++) {
            if (parkingSpots[i].getSpotStatus() == SpotStatus.FREE.toString()) {
                return i;
            }
        }
        return -1;
    }

    public String getParkingTicketNumber(Vehicle vehicle) {
        for (int i = 0; i < capacity; i++) {
            if (vehicles[i].getLicensePlate() == vehicle.getLicensePlate()) {
                return parkingTickets[i].getParkingTicketNumber();
            }
        }
        return "";
    }

    private String display(String action, int spot) {

        String tmp = "";

        if (action == "Remove") {
            tmp += "Removing vehicle\n";
        }
        else {
            tmp += "Adding vehicle\n";
        }

        tmp += "Parking spot: " +
                parkingSpots[spot].getSpotNumber() +
                "\n" +
                "Parking spot status: " +
                parkingSpots[spot].getSpotStatus() +
                "\n" +
                "Ticket number: " +
                parkingTickets[spot].getParkingTicketNumber() +
                "\n" +
                "Entrance time: " +
                parkingTickets[spot].getEntranceTime() +
                "\n";

        if (action == "Remove") {
            tmp += "Exit time: " +
                    parkingTickets[spot].getExitTime() +
                    "\n";
        }

        tmp +=  "Status: " +
                parkingTickets[spot].getPaymentStatus() +
                "\n" +
                "License plates: " +
                this.vehicles[spot].getLicensePlate() +
                "\n" +
                "Vehicle type: " +
                this.vehicles[spot].getVehicleType();
        return tmp;
    }
}

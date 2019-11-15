package parkinglot.Enums;

public enum VehicleType {
    MOTORCYCLE {
        public int getSize() {
            return 1;
        }
    },
    CAR {
        public int getSize() {
            return 1;
        }
    },
    BUS {
        public int getSize() {
            return 5;
        }
    };

    public abstract int getSize();
}

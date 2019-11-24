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
    VAN {
        public int getSize() {
            return 1;
        }
    };

    public abstract int getSize();
}

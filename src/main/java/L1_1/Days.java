package com.company;

public enum Days {
    MONDAY {
        public Days nextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        public Days nextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        public Days nextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        public Days nextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        public Days nextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        public Days nextDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        public Days nextDay() {
            return MONDAY;
        }
    };

    public abstract Days nextDay();
}


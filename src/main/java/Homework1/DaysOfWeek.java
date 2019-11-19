package Homework1;

public enum DaysOfWeek {
    SUNDAY {
        @Override
        DaysOfWeek nextDay() {
            return MONDAY;
        }
    },
    MONDAY {
        @Override
        DaysOfWeek nextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        DaysOfWeek nextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        DaysOfWeek nextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        DaysOfWeek nextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        DaysOfWeek nextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        DaysOfWeek nextDay() {
            return SUNDAY;
        }
    };

    private String day;


    DaysOfWeek() {
    }
    abstract DaysOfWeek nextDay();
    public String toString(){
        return super.toString();
    }
}

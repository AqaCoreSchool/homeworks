package WeekDays;

public enum WeekDays {
    MONDAY {
        @Override
        WeekDays nextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        WeekDays nextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        WeekDays nextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        WeekDays nextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        WeekDays nextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        WeekDays nextDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        @Override
        WeekDays nextDay() {
            return MONDAY;
        }
    };

    abstract WeekDays nextDay();
}

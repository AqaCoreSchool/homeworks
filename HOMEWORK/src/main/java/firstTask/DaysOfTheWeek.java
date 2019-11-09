package firstTask;

public enum DaysOfTheWeek {
    MONDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        @Override
        DaysOfTheWeek getNextDay() {
            return MONDAY;
        }
    };

    abstract DaysOfTheWeek getNextDay();
}

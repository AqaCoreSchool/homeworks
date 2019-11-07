package home.study;

enum WeekDay {
    MONDAY {
        @Override
        WeekDay getNextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        WeekDay getNextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        WeekDay getNextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        WeekDay getNextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        WeekDay getNextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        WeekDay getNextDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        @Override
        WeekDay getNextDay() {
            return MONDAY;
        }
    };

    abstract WeekDay getNextDay();

    @Override
    public String toString() {
        return super.toString();
    }
}

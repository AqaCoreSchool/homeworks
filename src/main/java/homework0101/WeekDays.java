package homework0101;

public enum WeekDays {
    MONDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    TUESDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    WEDNESDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    THURSDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    FRIDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    SATURDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[index+1];
        }
    },
    SUNDAY {
        @Override
        WeekDays nextDay(int index) {
            return days[0];
        }
    };

    static final WeekDays days[] = WeekDays.values();

    abstract WeekDays nextDay(int index);
}

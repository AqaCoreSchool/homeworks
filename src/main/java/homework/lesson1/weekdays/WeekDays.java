package homework.lesson1.weekdays;

public enum WeekDays {
    MONDAY {
        @Override
        public String nextDay() {
            return TUESDAY.toString();
        }
    },
    TUESDAY {
        @Override
        public String nextDay() {
            return WEDNESDAY.toString();
        }
    },
    WEDNESDAY {
        @Override
        public String nextDay() {
            return THURSDAY.toString();
        }
    },
    THURSDAY {
        @Override
        public String nextDay() {
            return FRIDAY.toString();
        }
    },
    FRIDAY {
        @Override
        public String nextDay() {
            return SATURDAY.toString();
        }
    },
    SATURDAY {
        @Override
        public String nextDay() {
            return SUNDAY.toString();
        }
    },
    SUNDAY {
        @Override
        public String nextDay() {
            return MONDAY.toString();
        }
    };

    public abstract String nextDay();
}

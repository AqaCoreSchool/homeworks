package homework.weekdays;

/**
 * This enum contains days of the week, and contains an abstract method that returns tomorrow day.
 *
 * @author Kontsevych Mykyta
 * @version 1.0 08 November 2019
 */

public enum WeekDays {

    MONDAY {
        @Override
        WeekDays getTomorrowDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        WeekDays getTomorrowDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        WeekDays getTomorrowDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        WeekDays getTomorrowDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        WeekDays getTomorrowDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        WeekDays getTomorrowDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        @Override
        WeekDays getTomorrowDay() {
            return MONDAY;
        }
    };

    abstract WeekDays getTomorrowDay();
}

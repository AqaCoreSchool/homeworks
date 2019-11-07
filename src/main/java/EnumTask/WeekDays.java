package EnumTask;

enum WeekDays{
    MONDAY{
        @Override
        public WeekDays nextDay(){
            return TUESDAY;
        }
    },
    TUESDAY{
        @Override
        public WeekDays nextDay(){
            return WEDNESDAY;
        }
    },
    WEDNESDAY{
        @Override
        public WeekDays nextDay(){
            return THURSDAY;
        }
    },
    THURSDAY{
        @Override
        public WeekDays nextDay(){
            return FRIDAY;
        }
    },
    FRIDAY{
        @Override
        public WeekDays nextDay(){
            return SATURDAY;
        }
    },
    SATURDAY{
        @Override
        public WeekDays nextDay(){
            return SUNDAY;
        }
    },
    SUNDAY{
        @Override
        public WeekDays nextDay(){
            return MONDAY;
        }
    };
    public abstract WeekDays nextDay();
}

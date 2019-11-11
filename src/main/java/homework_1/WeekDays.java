package homework_1;

public enum WeekDays {
    MONDAY {
        @Override
        public WeekDays next (){
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        public WeekDays next (){
            return WEDNESDAY;
        }
    },
    WEDNESDAY{
        @Override
        public WeekDays next (){
            return THURSDAY;
        }
    },
    THURSDAY{
        @Override
        public WeekDays next (){
            return FRIDAY;
        }
    },
    FRIDAY{
        @Override
        public WeekDays next (){
            return SATURDAY;
        }
    },
    SATURDAY{
        @Override
        public WeekDays next (){
            return SUNDAY;
        }
    },
    SUNDAY{
        @Override
        public WeekDays next (){
            return MONDAY;
        }
    };

    public abstract WeekDays next();


}



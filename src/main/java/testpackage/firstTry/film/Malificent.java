package testpackage.firstTry.film;

public class Malificent extends Films {
    private String arr[] ={"12:00","18:00","21:00"};

    @Override
    public void chooseTime(String film,String nameFilm,String date,String name) {
        System.out.println("Sessions for this time are available on your testpackage.firstTry.film:");
        for(int i =0;i<arr.length;i++){
            int a = i+1;
            System.out.println(a+"."+arr[i]);
        }
        int time = in.nextInt();
        concludingAnswer(film,nameFilm,date,name,arr[time-1]);
    }

    @Override
    public Films chooseDate(String film,String nameFilm,String name) {
        System.out.println("Enter date(for example 12/12/1212):");
        String date = in.nextLine();
        verifyDate(date);
        chooseTime(film,nameFilm,date,name);
        return this;
    }
}

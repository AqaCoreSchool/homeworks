package com.company;
import java.util.ArrayList;
import java.util.Scanner;

enum Day{
    MONDAY{
        public int action(int x){
            return x + 1;}
    },
    TUESDAY{
        public int action(int x){
            return x + 1;}
    },
    WEDNESDAY {
        public int action(int x) {
            return x + 1;
        }
    },
    THURSDAY {
        public int action(int x) {
            return x + 1;
        }
    },
    FRIDAY {
        public int action(int x) {
            return x + 1;
        }
    },
    SATURDAY {
        public int action(int x) {
            return x + 1;
        }
    },
    SUNDAY{
        public int action(int x) {
            return x ;
        }
    };

    public abstract int action(int x);
}


public class Main {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        for (Day d : Day.values())
            arr.add(String.valueOf(d));

        Scanner myObj = new Scanner(System.in);
        String current = myObj.nextLine();

        int inddex;
        switch(current){
            case "MONDAY":
                Day a = Day.MONDAY;
                inddex = a.action(0);
                System.out.println(arr.get(inddex));
                break;
            case "TUESDAY":
                Day b = Day.TUESDAY;
                inddex = b.action(1);
                System.out.println(arr.get(inddex));
                break;
            case "WEDNESDAY":
                Day c = Day.WEDNESDAY;
                inddex = c.action(2);
                System.out.println(arr.get(inddex));
                break;
            case "THURSDAY":
                Day d = Day.THURSDAY;
                inddex = d.action(3);
                System.out.println(arr.get(inddex));
                break;
            case "FRIDAY":
                Day f = Day.FRIDAY;
                inddex = f.action(4);
                System.out.println(arr.get(inddex));
                break;
            case "SATURDAY":
                Day r = Day.SATURDAY;
                inddex = r.action(5);
                System.out.println(arr.get(inddex));
                break;
            case "SUNDAY":
                Day n = Day.SUNDAY;
                inddex = n.action(0);
                System.out.println(arr.get(inddex));
                break;
            default:
                System.out.println("Your Input is bad, bro");
        }

    }
}

package emploee;

import java.util.Random;

public class Emploee{
    String name;
    double salary;
    boolean isHire;


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isHire() {
        return isHire;
    }

    @Override
    public String toString() {
      //  System.out.println( name+" "+salary+" "+isHire);
        int a =40- name.length();
        System.out.format(  "%s %s %"+a+"s %10s %5s %10s %5s","|",name,"|",salary,"|",isHire,"|\n" );
        System.out.println("----------------------------------------------------------------------------");
        return super.toString();
    }
}

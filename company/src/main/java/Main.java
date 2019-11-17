import com.github.javafaker.Faker;
import emploee.Director;
import emploee.Emploee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Emploee>employees = new LinkedList<Emploee>(  );
        WorkWithStuff work = new WorkWithStuff();
        employees = work.getStuff();
        System.out.println();
        work.filterBySalary( employees,900 );
            work.addEmpolee( employees,Stuff.values() );
    }
}

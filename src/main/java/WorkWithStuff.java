import com.github.javafaker.Faker;
import emploee.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WorkWithStuff {
    List getStuff() {
        Stuff stuff[] = Stuff.values();
        List<Emploee> employees = new LinkedList();
        Random number = new Random();
        Faker faker = new Faker();
        Emploee emploee;
        for (int i = 0; i < 5; i++) {
            switch (number.nextInt( 4 - 0 + 1 ) + 0) {
                case 0:
                    emploee = new Counter( faker.name().fullName(), 900 );
                    if(emploee.isHire())
                        employees.add( emploee );
                    break;
                case 1:
                    emploee =new QA( faker.name().fullName(), 1000 );
                    if(emploee.isHire())
                        employees.add( emploee );
                    break;
                case 2:
                    emploee = new Director( faker.name().fullName(), 2000, true );

                        employees.add( emploee );
                    break;
                case 3:
                    emploee  = new Developer( faker.name().fullName(), 1300 );
                    if(emploee.isHire())
                        employees.add( emploee );
                    break;
                case 4:
                    emploee =  new Mananger( faker.name().fullName(), 1000 );
                    if(emploee.isHire())
                    employees.add( emploee );
                    break;
            }
        }
        return employees;
    }

     List filterBySalary(List stuff, double salary) {
       List <Emploee>employees = stuff;
       Emploee emploee;
        for (int i = 0; i < employees.size() ; i++) {
            emploee = employees.get( i );
            if(emploee.getSalary()<salary) {
                employees.remove( i );
                i=-1;

            }
        }
printStuff( employees );
        return employees;
    }
    void printStuff(List stuff){
        StringBuilder sb = new StringBuilder();
        Emploee emploee;
        System.out.println("----------------------------------------------------------------------------");
        System.out.format( "%s %20s %20s %10s %5s %10s %5s","|","NAME","|","SALARY","|","ISHIRE","|\n" );
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i <stuff.size() ; i++) {
            emploee = (Emploee) stuff.get( i );
            emploee.toString();

        }

    }
     void addEmpolee(List employees, Stuff stuff[]){
        Scanner inputData = new Scanner( System.in );
        Scanner inputName = new Scanner( System.in );
        Scanner inputSalary = new Scanner( System.in );

        Emploee emploee = new Emploee();
        String name ="" ;
        double salary=0;
        int index = inputData.nextInt();
       end :while(true){
           switch (index){
               case 0:
                   System.out.println("input name");
                   name = inputData.nextLine();

                   emploee = new Counter( inputData.nextLine(),900,true );
        break;
        case 1:
            System.out.println("input name");
            name = inputName.nextLine();
            System.out.println("input salary");
            salary = inputSalary.nextDouble();
        emploee = new QA( name,salary,true );
        break end;
        case 2:
            System.out.println("input name");
            name = inputName.nextLine();
            System.out.println("input salary");
            salary = inputSalary.nextDouble();
        emploee = new Director( name,salary,true  );
        break end;
        case 3:
            System.out.println("input name");
            name = inputName.nextLine();
            System.out.println("input salary");
            salary = inputSalary.nextDouble();
        emploee = new Developer( name,salary,true  );
        break end;
        case 4:
            System.out.println("input name");
            name = inputName.nextLine();
            System.out.println("input salary");
            salary = inputSalary.nextDouble();
        emploee = new Mananger( name,salary,true  );
        break end;
        case 5:
        System.out.println("input name");

        System.out.println("Exit");
        break end;
        }

        }
        if(emploee.isHire())
        employees.add( emploee );
        printStuff( employees );
        }
        }

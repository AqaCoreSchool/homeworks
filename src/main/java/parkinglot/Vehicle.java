package parkinglot;

 abstract class Vehicle {

     private String form;
     private int countOfWheels;

     public Vehicle(String form, int countOfWheels) {
         this.form = form;
         this.countOfWheels = countOfWheels;
     }

     public abstract String getForm();

     public abstract void setForm(String form) ;

     public abstract int getStayOnParking();

     public abstract String getStateNumber();

     public abstract String getOwner();
 }
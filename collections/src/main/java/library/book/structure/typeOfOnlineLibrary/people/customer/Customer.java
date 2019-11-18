package library.book.structure.typeOfOnlineLibrary.people.customer;



import library.book.structure.typeOfOnlineLibrary.people.stuff.People;

import java.util.HashMap;
import java.util.Map;

public  class Customer extends People {
    private Map<String, String> books = new HashMap<String, String>();

    private long passportData;
    @Override
    protected void setName(String name){
     name =this.name;
    }
    @Override
   protected void setSex(boolean sex){
     sex = this.sex;
    }

   protected void setPassportData(){

   }
}

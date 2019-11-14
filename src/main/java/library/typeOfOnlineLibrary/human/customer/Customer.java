package library.typeOfOnlineLibrary.people.customer;

import library.typeOfOnlineLibrary.people.stuff.Human;

import java.util.HashMap;
import java.util.Map;

public  class Customer extends Human {
    private Map<String, String> books = new HashMap<String, String>();

    private long passportData;
    @Override
    protected void setName(String name){
        name =this.name;
    }
    @Override
   protected void setGender(boolean isMale){
        this.isMale = isMale;
    }

   protected void setPassportData(long passportData){
        this.passportData = passportData;
   }
}

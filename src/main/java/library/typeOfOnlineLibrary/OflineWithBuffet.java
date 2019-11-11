package library.typeOfOnlineLibrary;

import library.OflineLibrary;
import library.typeOfOnlineLibrary.people.stuff.*;

import java.util.HashMap;
import java.util.Map;

public class OflineWithBuffet extends OflineLibrary {
    private Map<String, String> products = new HashMap<String, String>();
    @Override
    protected  void workWithCustomer(){}
}

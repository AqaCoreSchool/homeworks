package library.book.structure.typeOfOnlineLibrary;



import library.book.structure.OflineLibrary;

import java.util.HashMap;
import java.util.Map;

public class OflineWithBuffet extends OflineLibrary {
    private Map<String, String> products = new HashMap<String, String>();
    @Override
    protected  void workWithCustomer(){}
}

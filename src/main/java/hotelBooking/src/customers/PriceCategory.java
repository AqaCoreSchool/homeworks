package customers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PriceCategory {

    public void selectionPriceCategory() {

        Map<Integer, Person> people = new HashMap<>();
        people.put(1, new Person("Child", 50));
        people.put(2, new Person("Child", 50));
        people.put(3, new Person("Child", 50));

        Set<Map.Entry<Integer, Person>> set = people.entrySet();

        for (Map.Entry<Integer, Person> me : set) {
            System.out.print(me.getKey());
            System.out.println(me.getValue());
        }
    }
}
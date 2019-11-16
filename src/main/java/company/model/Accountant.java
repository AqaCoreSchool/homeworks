package company.model;

import company.Company;
import company.Employee;
import company.interfaces.Workable;

/**
 * Represents an {@link Employee} as Accountant in {@link Company}
 * with implementation of {@link Workable} interface.
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public class Accountant extends Employee implements Workable {

    public Accountant(String name, int salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Working as Accountant");
    }
}

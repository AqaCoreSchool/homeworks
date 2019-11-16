package company.exception;

import company.Employee;

/**
 * Signals that an attempt to do something with
 * empty {@link Employee} list.
 *
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

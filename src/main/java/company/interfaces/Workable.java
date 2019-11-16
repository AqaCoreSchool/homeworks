package company.interfaces;

/**
 * A class implements the interface to let {@link company.model} classes
 * do some action. By convention, classes that implement this interface
 * should override {@link Workable#work()} with a public method.
 *
 * @author Pavlo Hrytsyshyn
 *  * @version 1.0
 *  * @since   2019-11-15
 */
public interface Workable {
    void work();
}

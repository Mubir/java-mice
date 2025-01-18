package mubir.fp;
/**
 *
 * A Supplier cannot throw checked exceptions because its
 * get() method does not declare a throws clause.
 * To handle exceptions in a Supplier, you must:->
 * Use a try-catch block inside the Supplier.
 * Wrap the checked exception in a RuntimeException.
 * Create a custom functional interface to allow checked exceptions.
 * */
@FunctionalInterface
public interface ThrowingSupplier<T, E extends Exception> {
    T get() throws E;
}

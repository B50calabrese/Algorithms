package main.com.acalabrese.sorters;

/**
 * A sorting interface that all of the sorters must implement.
 */
public interface SorterInterface<T extends Comparable> {
    /**
     * Sorts a list of comparables.
     * @param arr
     * @return a new list in sorted order.
     */
    public T[] sort(T[] arr);
}

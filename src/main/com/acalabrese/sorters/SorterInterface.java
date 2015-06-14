package main.com.acalabrese.sorters;

/**
 * A sorting interface that all of the sorters must implement.
 */
public interface SorterInterface {
    /**
     * Sorts a list of comparables.
     * @param arr
     * @return a new list in sorted order.
     */
    public Comparable[] sort(Comparable[] arr);

    /**
     * Returns the number of comparisons done on the previous sort call.
     */
    public int getNumberOfComparisons();
}

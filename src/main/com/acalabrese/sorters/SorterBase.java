package main.com.acalabrese.sorters;

/**
 * A sorting interface that all of the sorters must implement.
 */
public abstract class SorterBase {
    protected int numberOfComparisons;

    /**
     * Sorts a list of comparables.
     * @param arr
     * @return a new list in sorted order.
     */
    public abstract Comparable[] sort(Comparable[] arr);

    /**
     * Returns the number of comparisons done on the previous sort call.
     */
    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }
}

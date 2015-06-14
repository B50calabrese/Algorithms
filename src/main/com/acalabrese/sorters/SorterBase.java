package main.com.acalabrese.sorters;

/**
 * A sorting interface that all of the sorters must implement.
 */
public abstract class SorterBase {
    protected int numberOfComparisons;

    /**
     * Sorts a list of comparables.
     *
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

    /**
     * Used to swap two values at the given indices
     */
    public void swap(Comparable[] arr, int index1, int index2) {
        Comparable temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

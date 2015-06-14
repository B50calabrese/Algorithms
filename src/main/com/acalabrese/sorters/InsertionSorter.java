package main.com.acalabrese.sorters;

/**
 * Sorts a list of numbers using insertion sort.
 * <p/>
 * Insertion sort is a sorting algorithm also known as Poker Hand Sort. The idea is we will take
 * first element in the non-sorted portion of the list, and compare it from the top of the sorted
 * section down until there is a spot where it can fit.
 * <p/>
 * Average Case: O(n)
 * Worst Case: O(n^2)
 * Best Case: O(n^2)
 */
public class InsertionSorter extends SorterBase {
    @Override
    public Comparable[] sort(Comparable[] arr) {
        // Create a new copy of the array
        Comparable[] newArr = arr.clone();

        // Zero out the number of comparisons
        numberOfComparisons = 0;

        // We will be constantly shrinking the unsorted portion
        for (int sortedIndex = 1 ; sortedIndex < newArr.length - 1 ; sortedIndex++) {
            for (int index = sortedIndex ; index > 0 &&
                    newArr[index].compareTo(newArr[index - 1]) < 0 ; index--) {
                // Each incrementation of this should be a swap, and is therefore a comparison
                numberOfComparisons++;
                swap(newArr, index, index - 1);
            }
        }
        return newArr;
    }
}

package main.com.acalabrese.sorters;

/**
 * Sorts a list of numbers using selection sort.
 *
 * Selection sort is a sorting algorithm where on each iteration through the unsorted portion of the
 * list, we find the smallest element still unsorted. From there we swap the first element in the
 * unsorted portion with the first element in the unsorted portion thereby shrinking the unsorted
 * portion of the list.
 *
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 * Best Case: O(n^2)
 */
public class SelectionSorter extends SorterBase {
    @Override
    public Comparable[] sort(Comparable[] arr) {
        // Create a new copy of the array
        Comparable[] newArr = arr.clone();

        // Zero out the number of comparisons
        numberOfComparisons = 0;

        // We will be constantly shrinking the unsorted portion
        for (int sortedIndex = 0 ; sortedIndex < newArr.length - 1 ; sortedIndex++) {
            // Our smallest value starts at the first index that isn't sorted.
            int leastValIndex = sortedIndex;

            for (int index = sortedIndex ; index < newArr.length ; index++) {
                // We need to increment the number of comparisons
                numberOfComparisons++;

                // If the value we are looking at is the smallest, then we want to ensure that
                // we save its index
                if (newArr[index].compareTo(newArr[leastValIndex]) < 0) {
                    leastValIndex = index;
                }
            }

            // Now that we have the smallest, we need to swap the values
            Comparable temp = newArr[leastValIndex];
            newArr[leastValIndex] = newArr[sortedIndex];
            newArr[sortedIndex] = temp;
        }
        return newArr;
    }
}

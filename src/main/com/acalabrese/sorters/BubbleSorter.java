package main.com.acalabrese.sorters;

/**
 * Sorts a list of numbers using bubble sort.
 *
 * Bubble sort is a sorting algorithm where you step through the list and each time you step you
 * test adjacent elements to see if they are in the wrong order. If the elements are in the wrong
 * order than you swap the two elements until you reach the end of the list.
 *
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 * Best Case: O(n)
 */
public class BubbleSorter extends SorterBase {
    @Override
    public Comparable[] sort(Comparable[] arr) {
        // Create a new copy of the array
        Comparable[] newArr = arr.clone();

        // Zero out the number of comparisons
        numberOfComparisons = 0;

        // This will keep track if we swapped or not. If there are no swaps, then the list is sorted
        boolean haveSwapped = true;
        while (haveSwapped) {
            haveSwapped = false;

            // Go through each element and if there are any that are out of order, swap them and
            // set the flag to true to do another pass.
            for (int i = 0 ; i < newArr.length - 1 ; i++) {
                // We will be comparing so we need to increment our counter
                numberOfComparisons++;
                if (newArr[i + 1].compareTo(newArr[i]) < 0) {
                    Comparable temp = newArr[i];
                    newArr[i] = newArr[i + 1];
                    newArr[i + 1] = temp;
                    haveSwapped = true;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        BubbleSorter sorter = new BubbleSorter();
        Integer[] arr = (Integer[]) sorter.sort(new Integer[] {3, 7, 1, 23, 5, 3, 4});
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}

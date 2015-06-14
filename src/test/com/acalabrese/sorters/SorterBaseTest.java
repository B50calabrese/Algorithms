package test.com.acalabrese.sorters;

import junit.framework.TestCase;
import main.com.acalabrese.sorters.BubbleSorter;
import main.com.acalabrese.sorters.SelectionSorter;
import main.com.acalabrese.sorters.SorterBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * A base testing class  all of the sorter tests will extend in order to get various methods that
 * could be useful.
 */
@RunWith(Parameterized.class)
public class SorterBaseTest extends TestCase {
    // Used to print out the list of sorted values
    public final static boolean PRINT_LISTS = true;
    public final static int MAX_PRINT_LIST_SIZE = 20;

    // Used to print out the number of comparisons
    public final static boolean PRINT_COMPARISONS = false;

    // The highest random value that this base class will provide if not given an upper bound.
    protected final static int MAX_RANDOM_VALUE = 10000;

    protected final static int SMALL_SIZE = 10;
    protected final static int MEDIUM_SIZE = 100;
    protected final static int LARGE_SIZE = 1000;

    private SorterBase sorterBase;

    @Rule
    public TestName name;

    public SorterBaseTest(SorterBase sorterBase) {
        this.sorterBase = sorterBase;
        name = new TestName();
    }

    /*
     * Test Methods
     */

    @Test
    public void testOneElement() {
        testSorter(sorterBase, new Integer[]{1}, name.getMethodName());
    }

    @Test
    public void testSortedElementSmallList() {
        testSorter(sorterBase, getSortedList(SMALL_SIZE), name.getMethodName());
    }

    @Test
    public void testSortedElementMediumList() {
        testSorter(sorterBase, getSortedList(MEDIUM_SIZE), name.getMethodName());
    }

    @Test
    public void testSortedElementLargeList() {
        testSorter(sorterBase, getSortedList(LARGE_SIZE), name.getMethodName());
    }

    @Test
    public void testRandomElementSmallList() {
        testSorter(sorterBase, getRandomList(SMALL_SIZE), name.getMethodName());
    }

    @Test
    public void testRandomElementMediumList() {
        testSorter(sorterBase, getRandomList(MEDIUM_SIZE), name.getMethodName());
    }

    @Test
    public void testRandomElementLargeList() {
        testSorter(sorterBase, getRandomList(LARGE_SIZE), name.getMethodName());
    }

    /**
     * Tests the sorter on the given list
     */
    protected boolean testSorter(SorterBase sorter, Integer[] list, String testName) {
        // The list "sorted"
        Integer[] newList = (Integer[]) sorter.sort(list);
        boolean res = isSorted(newList);

        String outputString = testName + " " + (res?"Passed":"Failed") + "\n";
        if (PRINT_LISTS && MAX_PRINT_LIST_SIZE > newList.length) {
            String newListString = "";
            String listString = "";
            for (int i = 0 ; i < newList.length ; i++) {
                newListString += newList[i] + " ";
                listString += list[i] + " ";
            }
            outputString += "Unsorted list : " + listString + "\n";
            outputString += "Sorted list : " + newListString + "\n";
        }

        if (PRINT_COMPARISONS) {
            outputString += "Number of comparisons : " + sorter.getNumberOfComparisons() + "\n";
        }

        System.out.println(outputString);

        return res;
    }

    /**
     * Provides a list of integers of the given size and the list will be sorted.
     */
    protected Integer[] getSortedList(int size) {
        Integer[] list = new Integer[size];
        for (int i = 0 ; i < size ; i++) {
            list[i] = i;
        }
        return list;
    }

    /**
     * Returns a list of random numbers, where the max number in that list is 10000
     */
    protected Integer[] getRandomList(int size) {
        return getRandomList(size, MAX_RANDOM_VALUE);
    }

    /**
     * Returns a list of random numbers, where the max number in that list is maxValue
     * @param size the size of the list
     * @param maxValue the highest value for the numbers
     */
    protected Integer[] getRandomList(int size, int maxValue) {
        Random random = new Random();
        Integer[] list = new Integer[size];
        for (int i = 0 ; i < size ; i++) {
            list[i] = random.nextInt(maxValue);
        }
        return list;
    }

    /**
     * Tests a list to see if it is sorted
     */
    protected boolean isSorted(Comparable[] list) {
        for (int i = 0 ; i < list.length - 1 ; i++) {
            if (list[i].compareTo(list[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return (Collection<Object[]>) Arrays.asList(
                new Object[]{new BubbleSorter()},
                new Object[]{new SelectionSorter()}
        );
    }
}
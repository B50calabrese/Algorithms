package test.com.acalabrese.sorters;

import junit.framework.TestCase;
import main.com.acalabrese.sorters.BubbleSorter;
import main.com.acalabrese.sorters.SorterInterface;
import org.junit.Test;
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
    // Used to print out various things from the test cases
    public final static boolean PRINT_TEST_CASES = true;

    // The highest random value that this base class will provide if not given an upper bound.
    protected final static int MAX_RANDOM_VALUE = 10000;

    protected final static int SMALL_SIZE = 10;
    protected final static int MEDIUM_SIZE = 100;
    protected final static int LARGE_SIZE = 1000;

    SorterInterface sorterInterface;

    public SorterBaseTest(SorterInterface sorterInterface) {
        this.sorterInterface = sorterInterface;
    }

    /*
     * Test Methods
     */

    @Test
    public void testOneElement() {
        testSorter(sorterInterface, new Integer[] {1});
    }

    @Test
    public void testSortedElementSmallList() {
        testSorter(sorterInterface, getSortedList(SMALL_SIZE));
    }

    @Test
    public void testSortedElementMediumList() {
        testSorter(sorterInterface, getSortedList(MEDIUM_SIZE));
    }

    @Test
    public void testSortedElementLargeList() {
        testSorter(sorterInterface, getSortedList(LARGE_SIZE));
    }

    @Test
    public void testRandomElementSmallList() {
        testSorter(sorterInterface, getRandomList(SMALL_SIZE));
    }

    @Test
    public void testRandomElementMediumList() {
        testSorter(sorterInterface, getRandomList(MEDIUM_SIZE));
    }

    @Test
    public void testRandomElementLargeList() {
        testSorter(sorterInterface, getRandomList(LARGE_SIZE));
    }

    /**
     * Tests the sorter on the given list
     */
    protected boolean testSorter(SorterInterface sorter, Integer[] list) {
        Integer[] newList = (Integer[]) sorter.sort(list);
        String newListString = "";
        String listString = "";
        if (PRINT_TEST_CASES) {
            for (int i = 0 ; i < newList.length ; i++) {
                newListString += newList[i] + " ";
                listString += list[i] + " ";
            }
            System.out.println("Unsorted list : " + listString);
            System.out.println("Sorted list : " + listString);
            System.out.println("Number of comparisons : " + sorter.getNumberOfComparisons());
        }
        return isSorted(newList);
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
                new Object[]{new BubbleSorter()}
        );
    }
}
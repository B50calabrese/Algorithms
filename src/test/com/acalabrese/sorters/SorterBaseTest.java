package test.com.acalabrese.sorters;

import junit.framework.TestCase;

import java.util.Random;

/**
 * A base testing class  all of the sorter tests will extend in order to get various methods that
 * could be useful.
 */
public abstract class SorterBaseTest extends TestCase {
    // The highest random value that this base class will provide if not given an upper bound.
    protected final static int MAX_RANDOM_VALUE = 10000;

    /**
     * Provides a list of integers of the given size and the list will be sorted.
     */
    protected int[] getSortedList(int size) {
        int[] list = new int[size];
        for (int i = 0 ; i < size ; i++) {
            list[i] = i;
        }
        return list;
    }

    /**
     * Returns a list of random numbers, where the max number in that list is 10000
     */
    protected int[] getRandomList(int size) {
        return getRandomList(size, MAX_RANDOM_VALUE);
    }

    /**
     * Returns a list of random numbers, where the max number in that list is maxValue
     * @param size the size of the list
     * @param maxValue the highest value for the numbers
     */
    protected int[] getRandomList(int size, int maxValue) {
        Random random = new Random();
        int[] list = new int[size];
        for (int i = 0 ; i < size ; i++) {
            list[i] = random.nextInt(maxValue);
        }
        return list;
    }
}
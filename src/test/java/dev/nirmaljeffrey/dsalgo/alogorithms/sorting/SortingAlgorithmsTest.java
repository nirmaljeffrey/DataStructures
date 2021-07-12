package dev.nirmaljeffrey.dsalgo.alogorithms.sorting;

import dev.nirmaljeffrey.dsalgo.algorithms.sorting.*;
import dev.nirmaljeffrey.dsalgo.utils.TestingUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgorithmsTest {
    private ArrayList<Sorter> sorters;

    @Before
    public void setUp() {
        sorters = new ArrayList<>();
        sorters.add(new SelectionSort());
        sorters.add(new BubbleSort());
        sorters.add(new InsertionSort());
        sorters.add(new MergeSort());
    }

    @Test
    public void verifySortingAlgorithms_smallPositiveIntegersOnly() {
        for(int size = 0; size < 1000; size++) {
            for (Sorter sorter: sorters) {
                int[] array = TestingUtils.randomIntegerArray(size, 0, 51);
                int[] arrayCopy = array.clone();
                Arrays.sort(arrayCopy);
                sorter.sort(array);
                Assert.assertArrayEquals(arrayCopy, array);
            }
        }
    }



    @Test
    public void verifySortingAlgorithms_smallNegativeIntegersOnly() {
        for(int size = 0; size < 1000; size++) {
            for (Sorter sorter: sorters) {
                int[] array = TestingUtils.randomIntegerArray(size, -50, 51);
                int[] arrayCopy = array.clone();
                Arrays.sort(arrayCopy);
                sorter.sort(array);
                Assert.assertArrayEquals(arrayCopy, array);
            }
        }
    }
    @After
    public void tearDown() {
        sorters = null;
    }
}

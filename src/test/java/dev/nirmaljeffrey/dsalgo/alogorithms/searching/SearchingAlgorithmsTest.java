package dev.nirmaljeffrey.dsalgo.alogorithms.searching;

import dev.nirmaljeffrey.dsalgo.algorithms.searching.BinarySearch;
import dev.nirmaljeffrey.dsalgo.algorithms.searching.LinearSearch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SearchingAlgorithmsTest {
    private ArrayList<Integer> integerList;
    @Before
    public void setUp() {
         integerList =  new ArrayList<>();
         for (int i = 0; i <= 100; i+=2) {
             integerList.add(i);
         }
    }

    @Test
    public void testBinarySearchIteratively() {
        Assert.assertEquals(9 ,BinarySearch.iterativeBinarySearch(18, integerList));
        Assert.assertEquals(-1 ,BinarySearch.iterativeBinarySearch(19, integerList));
    }

    @Test
    public void testBinarySearchRecursively() {
        Assert.assertEquals(9 ,BinarySearch.recursiveBinarySearch(18, integerList));
        Assert.assertEquals(-1 ,BinarySearch.recursiveBinarySearch(19, integerList));
    }

    @Test
    public void testLinearSearchIteratively() {
        Assert.assertEquals(9 , LinearSearch.iterativeLinearSearch(18, integerList));
        Assert.assertEquals(-1 ,LinearSearch.iterativeLinearSearch(19, integerList));
    }

    @Test
    public void testLinearSearchRecursively() {
        Assert.assertEquals(9 , LinearSearch.recursiveLinearSearch(18, integerList));
        Assert.assertEquals(-1 ,LinearSearch.recursiveLinearSearch(19, integerList));
    }

    @After
    public void tearDown() {
        integerList =  null;
    }

}

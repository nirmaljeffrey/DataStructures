package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

public class InsertionSort implements Sorter {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int holeIndex = i;
            while (holeIndex > 0 && array[holeIndex - 1] > value) {
                array[holeIndex] = array[holeIndex - 1];
                --holeIndex;
            }
            array[holeIndex] = value;
        }
    }
}

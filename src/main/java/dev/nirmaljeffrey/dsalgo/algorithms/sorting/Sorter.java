package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

public interface Sorter {
    void sort(int[] array);

    static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

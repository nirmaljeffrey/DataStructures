package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

public class SelectionSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
          Sorter.swap(arr, i, minIndex);
        }
    }
}

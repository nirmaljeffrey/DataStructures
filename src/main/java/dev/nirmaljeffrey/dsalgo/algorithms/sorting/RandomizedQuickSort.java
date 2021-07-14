package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

import dev.nirmaljeffrey.dsalgo.common.TestingUtils;

public class RandomizedQuickSort implements Sorter {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private int partition(int[] array, int start, int end) {
        int tempPivotIndex = TestingUtils.randValue(start, end);
        Sorter.swap(array, tempPivotIndex, end);
        int pivotIndex = end;
        int pivot = array[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                Sorter.swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        Sorter.swap(array, partitionIndex, pivotIndex);
        return partitionIndex;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex =  partition(array, start, end);
        quickSort(array, start, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, end);
    }
}

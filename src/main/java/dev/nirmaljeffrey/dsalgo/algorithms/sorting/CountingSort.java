package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

import dev.nirmaljeffrey.dsalgo.common.TestingUtils;

public class CountingSort implements Sorter {
    @Override
    public void sort(int[] array) {
       countingSort(array);
    }

    private void countingSort(int[] inputArray) {
        if (inputArray.length < 2) {
            return;
        }
        int max = TestingUtils.findMaxValueInArray(inputArray);
        int min = TestingUtils.findMinValueInArray(inputArray);
        int range = max - min + 1;
        int[] countingArray = new int[range];
        for (int i = 0; i < inputArray.length; i++) {
            int countingArrayIndex = inputArray[i] - min;
            countingArray[countingArrayIndex]++;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        int[] outputArray = new int[inputArray.length];
        for (int i = inputArray.length - 1; i >= 0; i--) {
            int countingArrayIndex = inputArray[i] - min;
            int outputArrayIndex = --countingArray[countingArrayIndex];
            outputArray[outputArrayIndex] = inputArray[i] ;
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = outputArray[i];
        }
    }
}

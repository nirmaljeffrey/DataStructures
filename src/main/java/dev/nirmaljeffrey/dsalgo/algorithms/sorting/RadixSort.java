package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

import dev.nirmaljeffrey.dsalgo.common.TestingUtils;

/**
 *    Negative Integers are not supported in RadixSort
 *    Its a stable sorting algorithm
 *    It is based on countingSort algorithm
 *    This algorithm can be used on numbers only
 *
 */
public class RadixSort implements Sorter {

    @Override
    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int max = TestingUtils.findMaxValueInArray(array);
        for (int position = 1; max / position > 0; position *= 10) {
            countingSort(array, max, position);
        }
    }


    private void countingSort(int[] inputArray, int max, int position) {
        if (inputArray.length < 2) {
            return;
        }
        int[] countArray = new int[10]; // Index from 0 to 9

        for (int i = 0; i < inputArray.length; i++) {
            // if inputArray[i] is 623 and position is 1, then (623 / 1) % 10 = 3
            // if inputArray[i] is 623 and position is 10, then (623 / 10) % 10 = 2
            // if inputArray[i] is 623 and position is 100, then (623 / 100) % 10 = 6
            int countArrayIndex = (inputArray[i] / position) % 10;
            countArray[countArrayIndex]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] =  countArray[i] + countArray[i - 1];
        }

        int[] outputArray = new int[inputArray.length];

        for (int i = inputArray.length - 1; i >= 0; i--) {
           int countArrayIndex = (inputArray[i] / position) % 10;
           int outputArrayIndex = --countArray[countArrayIndex];
           outputArray[outputArrayIndex] = inputArray[i];
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = outputArray[i];
        }
    }
}

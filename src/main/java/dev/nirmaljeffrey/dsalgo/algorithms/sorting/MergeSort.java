package dev.nirmaljeffrey.dsalgo.algorithms.sorting;

public class MergeSort implements Sorter {
    @Override
    public void sort(int[] array) {
        int totalLength = array.length;
        if (totalLength < 2) {
            return;
        }
        int midValue = totalLength / 2;
        int[] leftArray = new int[midValue];
        int[] rightArray = new int[totalLength - midValue];
        for (int i = 0; i < midValue; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midValue; i < totalLength; i++) {
            rightArray[i - midValue] = array[i];
        }
        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[index++] = leftArray[leftIndex++];
            } else {
                array[index++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length) {
            array[index++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightArray.length) {
            array[index++] = rightArray[rightIndex++];
        }
    }
}

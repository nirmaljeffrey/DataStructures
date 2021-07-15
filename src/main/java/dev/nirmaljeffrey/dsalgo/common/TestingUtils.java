package dev.nirmaljeffrey.dsalgo.common;

public class TestingUtils {

    // Generates an array of random values where every number is between
    // [min, max) and there are possible repeats.
    public static int[] randomIntegerArray(int sz, int min, int max) {
        int[] ar = new int[sz];
        for (int i = 0; i < sz; i++) ar[i] = randValue(min, max);
        return ar;
    }

    // Generates a random number between [min, max)
    public static int randValue(int min, int max) {
        return min + (int) (Math.random() * ((max - min)));
    }

    public static int findMaxValueInArray(int[] array) {
        if (array.length < 2) {
            return array[0];
        }
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static int findMinValueInArray(int[] array) {
        if (array.length < 2) {
            return array[0];
        }
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}

package dev.nirmaljeffrey.dsalgo.utils;

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
}

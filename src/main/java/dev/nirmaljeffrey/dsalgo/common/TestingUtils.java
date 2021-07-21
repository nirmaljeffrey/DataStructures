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



    public static int[] getPreOrderResultArray() {
        return new int[]{16, 8, 5, 2, 9, 18, 17, 22};
    }

    public static int[] getInOrderResultArray() {
        return new int[]{2, 5, 8, 9, 16, 17, 18, 22};
    }

    public static int[] getPostOrderResultArray() {
        return new int[]{2, 5, 9, 8, 17, 22, 18, 16};
    }

    public static int[] getLevelOrderResultArray() {
        return new int[]{16, 8, 18, 5, 9, 17, 22, 2};
    }

    // use only in testing and for integer dataType only
    public static boolean validateBinarySearchTreeInvariant(TreePrinter.PrintableNode<Integer> node) {
        return validateBinarySearchTreeInvariant(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    // use only in testing and for integer dataType only
    private static boolean validateBinarySearchTreeInvariant(TreePrinter.PrintableNode<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }
        return node.getData() > min && node.getData() < max
                && validateBinarySearchTreeInvariant(node.getLeft(), min, node.getData())
                && validateBinarySearchTreeInvariant(node.getRight(), node.getData(), max);
    }
}

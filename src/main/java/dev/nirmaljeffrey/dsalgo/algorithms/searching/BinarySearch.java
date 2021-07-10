package dev.nirmaljeffrey.dsalgo.algorithms.searching;

import java.util.ArrayList;

public class BinarySearch {


    public static <T extends Comparable<T>> int recursiveBinarySearch(T value, ArrayList<T> list) {
        int start = 0;
        int end = list.size() - 1;
        return recursiveBinarySearch(value, start, end, list);
    }

    private static <T extends Comparable<T>> int recursiveBinarySearch(T value, int start, int end, ArrayList<T> list) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int comparedValue = value.compareTo(list.get(mid));
        if (comparedValue == 0) {
            return mid;
        } else if (comparedValue > 0) {
           return recursiveBinarySearch(value, mid + 1, end, list);
        } else {
            return recursiveBinarySearch(value, start, mid - 1, list);
        }
    }

    public static <T extends Comparable<T>> int iterativeBinarySearch(T value, ArrayList<T> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int comparedValue = value.compareTo(list.get(mid));
            if(comparedValue == 0) {
                return mid;
            } else if (comparedValue > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

package dev.nirmaljeffrey.dsalgo.algorithms.searching;

import java.util.ArrayList;

public class LinearSearch {

    public static <T> int recursiveLinearSearch(T value, ArrayList<T> list) {
        return recursiveLinearSearch(value, 0, list);
    }

    private static <T> int recursiveLinearSearch(T value, int index, ArrayList<T> list) {
        if (index == list.size()) {
            return -1;
        }
        if (value.equals(list.get(index))) {
            return index;
        }
        return recursiveLinearSearch(value, index + 1, list);
    }

    public static <T> int iterativeLinearSearch(T value, ArrayList<T> list) {
      for (int i = 0; i < list.size(); i++) {
          if (value.equals(list.get(i))) {
              return i;
          }
      }
      return -1;
    }
}

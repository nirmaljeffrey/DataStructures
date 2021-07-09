package dev.nirmaljeffrey.dsalgo.algorithms.searching;

import java.util.ArrayList;

public class LinearSearch {

    public static <T> int iterativeLinearSearch(T value, ArrayList<T> list) {
      for (int i = 0; i < list.size(); i++) {
          if (value.equals(list.get(i))) {
              return i;
          }
      }
      return -1;
    }
}

package dev.nirmaljeffrey.dsalgo.datastructures.tree.trie;

public interface Trie {

    void insert(String word);

    boolean isEmpty();

    boolean search(String word);

    boolean startsWith(String prefix);

    boolean delete(String word);
}

package dev.nirmaljeffrey.dsalgo.common;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isCompleteWord;

    public TrieNode() {
        children = new HashMap<>();
    }
}

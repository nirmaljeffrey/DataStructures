package dev.nirmaljeffrey.dsalgo.datastructures.tree.trie;


import dev.nirmaljeffrey.dsalgo.common.TrieNode;


public class RecursiveTrie implements Trie {
    private TrieNode rootNode;

    public RecursiveTrie() {
        rootNode = new TrieNode();
    }

    @Override
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("Word should br null or empty");
        }
        insertRecursive(word, rootNode, 0);
    }

    @Override
    public boolean isEmpty() {
        return rootNode.children.isEmpty();
    }

    @Override
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = getLastNodeRecursive(word, rootNode, 0);
        return node != null && node.isCompleteWord;
    }

    @Override
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode node = getLastNodeRecursive(prefix, rootNode, 0);
        return node != null;
    }

    @Override
    public boolean delete(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("Word should br null or empty");
        }
        return false;
    }

    private void insertRecursive(String word, TrieNode currentNode, int index) {
        if (index == word.length()) {
            currentNode.isCompleteWord = true;
            return;
        }
        char character = word.charAt(index);
        TrieNode temp = currentNode.children.get(character);
        if (temp == null) {
            temp = new TrieNode();
            currentNode.children.put(character, temp);
        }
        insertRecursive(word, temp, index + 1);
    }

    private TrieNode getLastNodeRecursive(String word, TrieNode currentNode, int index) {
        if (index == word.length()) {
            return currentNode;
        }
        char character = word.charAt(index);
        TrieNode temp = currentNode.children.get(character);
        if (temp == null) {
            return null;
        }
        return getLastNodeRecursive(word, temp, index + 1);
    }
}

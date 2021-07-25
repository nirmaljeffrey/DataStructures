package dev.nirmaljeffrey.dsalgo.datastructures.tree.trie;

import dev.nirmaljeffrey.dsalgo.common.TrieNode;

public class IterativeTrie implements Trie {
    private TrieNode rootNode;

    public IterativeTrie() {
        this.rootNode = new TrieNode();
    }

    @Override
    public void insert(String word) {
      if (word == null || word.length() == 0) {
          throw new IllegalArgumentException("Word should br null or empty");
      }
      TrieNode currentNode = rootNode;
      for (int i = 0; i < word.length(); i++) {
          char character = word.charAt(i);
          TrieNode temp = currentNode.children.get(character);
          if (temp == null) {
              temp = new TrieNode();
              currentNode.children.put(character, temp);
          }
          currentNode = temp;
      }
      currentNode.isCompleteWord = true;
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
        TrieNode node = getLastNode(word);
        return node != null && node.isCompleteWord;
    }

    @Override
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode node = getLastNode(prefix);
        return node != null;
    }

    private TrieNode getLastNode(String word) {
        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode temp = currentNode.children.get(character);
            if (temp == null){
                return null;
            }
            currentNode = temp;
        }
        return currentNode;
    }

    @Override
    public boolean delete(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("Word should br null or empty");
        }
        return false;
    }
}

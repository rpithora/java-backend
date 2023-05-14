package com.shaurya._16companies.optum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    List<Integer> indexes;
}

public class AllAnagram {

    public static void main(String[] args) {
        String words[] = {"cat", "dog", "tac", "god", "act"};
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        print(root, words);
    }

    private static void print(TrieNode root, String[] words) {
        if (root == null) {
            return;
        }
        if (root.isEnd) {
            for (int i : root.indexes) {
                System.out.println(words[i]);
            }
            return;
        }
        for (int i = 0; i < 26; i++) {
            print(root.children[i], words);
        }
    }

    private static void buildTrie(TrieNode root, String[] words) {

        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            insert(root, arr, i);
        }
    }

    private static void insert(TrieNode root, char[] word, int index) {
        TrieNode current = root;
        int id;
        for (int i = 0; i < word.length; i++) {
            id = word[i] - 'a';
            if (current.children[id] == null) {
                current.children[id] = new TrieNode();
            }
            current = current.children[id];
        }
        current.isEnd = true;
        if (current.indexes == null) {
            current.indexes = new ArrayList<>();
            current.indexes.add(index);
        } else {
            current.indexes.add(index);
        }
    }
}

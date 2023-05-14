package com.shaurya._14trie;


import java.util.Arrays;
import java.util.LinkedList;

public class PrintAllAnagram {
    public static void main(String[] args) {
        Trie root = new Trie();
        String words[] = {"cat", "dog", "tac", "god", "act" };
        insert(root, words);
        print(root, words);
    }

    private static void print(Trie root, String[] words) {
        if (root == null) {
            return;
        }
        if (root.isEnd) {
            for (int index : root.head) {
                System.out.print(words[index] + " ");
            }
        }
        for (int i = 0; i < 26; i++) {
            print(root.children[i], words);
        }
    }

    private static void insert(Trie root, String[] words) {
        for (int i = 0; i < words.length; i++) {
            char[] buf = words[i].toCharArray();
            Arrays.sort(buf);
            insertIntoTrie(root, buf, i);
        }
    }

    private static void insertIntoTrie(Trie root, char []word, int index) {
        Trie curr = root;
        int id;
        for (int i = 0; i < word.length; i++) {
            id = word[i] - 'a';
            if (curr.children[id] == null) {
                curr.children[id] = new Trie();
            }
            curr = curr.children[id];
        }
        curr.isEnd = true;
        curr.head.add(index);
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
        LinkedList<Integer> head;

        public Trie() {
            Arrays.fill(children, null);
            isEnd = false;
            head = new LinkedList<>();
        }
    }
}

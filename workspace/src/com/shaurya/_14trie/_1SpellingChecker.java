package com.shaurya._14trie;

import java.util.Arrays;

/**
 * Given an array of words A (dictionary) and another array B (which contain some words).
 * <p>
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 * <p>
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 * <p>
 * Such problems can be seen in real life when we work on any online editor (like Google Document), if the word is not valid it is underlined by a red line.
 * <p>
 * NOTE: Try to do this in O(n) time complexity.
 */
public class _1SpellingChecker {

    public static void main(String[] args) {
        String[] A = {"hat", "cat", "rat"};
        String[] B = {"cat", "ball"};
        _1SpellingChecker spellingChecker = new _1SpellingChecker();
        Arrays.stream(spellingChecker.solve(A, B)).forEach(s -> System.out.print(s + " "));
    }

    public int[] solve(String[] A, String[] B) {

        TrieNode node = new TrieNode();

        for (int i = 0; i < A.length; i++) {
            insert(node, A[i]);
        }

        int[] ans = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            ans[i] = search(node, B[i]);
        }

        return ans;
    }

    public void insert(TrieNode root, String word) // TC : O(Length of Word)
    {
        TrieNode curr = root;

        int idx;

        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';

            if (curr.childrenNode[idx] == null) {
                curr.childrenNode[idx] = new TrieNode();
            }
            curr = curr.childrenNode[idx];
        }

        curr.isEnd = true;
    }

    public int search(TrieNode root, String word) // TC : O(Length of Word)
    {
        TrieNode curr = root;

        int idx;

        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';

            if (curr.childrenNode[idx] == null) {
                return 0;
            }
            curr = curr.childrenNode[idx];
        }

        if (curr.isEnd == true) {
            return 1;
        }

        return 0;
    }

    static class TrieNode // TC : O(Length Of Longest Word) || SC : O(N*l) - N is total word in Array
    {
        TrieNode[] childrenNode = new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
            Arrays.fill(childrenNode, null);
            isEnd = false;
        }
    }
}


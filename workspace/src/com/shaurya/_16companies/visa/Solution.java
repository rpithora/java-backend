package com.shaurya._16companies.visa;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    int count = 0;
    ArrayList<String> list = new ArrayList<>();

    public Node() {
    }

    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public void updateList(String word) {
        list.add(word);
    }
}

class Trie {
    private
    Node root; //Initialize your data structure here 

    Trie() {
        root = new Node();
    } //Inserts a word into the trie

    public void insert(String word, String actualWord) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
        node.updateList(actualWord);
    }     //Returns if the word is in the trie


    public Node search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return node;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return node;
        }
        return node;
    }
}

class Result {
    static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }        /*     * Complete the 'getSearchResults' function below.     *     * The function is expected to return a 2D_STRING_ARRAY.     * The function accepts following parameters:     *  1. STRING_ARRAY words     *  2. STRING_ARRAY queries     */

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {    // Write your code here
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(sort(word), word);
        }
        for (String query : queries) {
            Node node = trie.search(sort(query));
            List<String> temp = new ArrayList<>();
            if (node.isEnd()) {
                temp.addAll(node.list);
            }
            Collections.sort(temp);
            result.add(temp);
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());
        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());
        List<List<String>> result = Result.getSearchResults(words, queries);
        result.stream().map(r -> r.stream().collect(joining(" "))).map(r -> r + "\n").collect(toList()).forEach(e -> {
            try {
                bufferedWriter.write(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
    }
}
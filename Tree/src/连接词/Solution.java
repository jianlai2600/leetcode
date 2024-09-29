package 连接词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    class Trie {
        Trie[]children;
        boolean isEnd;
        Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
    Trie trie = new Trie();
    public boolean isValid(String word, int start, boolean[]visited) {

        if (start == word.length()) {
            return true;
        }
        if (visited[start]) {
            return false;
        }
        Trie node = trie;
        visited[start] = true;

        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            node = node.children[index];

            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (isValid(word, i + 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void insert(String word) {

        int n = word.length();
        Trie node = trie;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a, b)->a.length() - b.length());
        List<String>ret = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.isEmpty()) {
                continue;
            }
            boolean[]visited = new boolean[word.length()];
            if (isValid(word, 0, visited)) {
                ret.add(word);
            } else {
                insert(word);
            }
        }

        return ret;
    }
    public static void main(String[] args){

        String[]words = {"cat","cats","dog","catsdogcats"};

        Solution sol = new Solution();
        List<String> ret = sol.findAllConcatenatedWordsInADict(words);

        for (String s : ret) {
            System.out.println(s);
        }
    }
}


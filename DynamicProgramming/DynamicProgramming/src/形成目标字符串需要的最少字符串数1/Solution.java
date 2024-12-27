package 形成目标字符串需要的最少字符串数1;

import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    public void insert(TrieNode root, String word) {

        int n = word.length();

        TrieNode cur = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    public List<Integer> search(TrieNode root, String word, int pos) {

        int n = word.length();
        List<Integer>res = new ArrayList<>();
        TrieNode cur = root;

        for (int i = pos; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                break;
            }
            cur = cur.children[c - 'a'];
            res.add(i - pos + 1);
        }
        return res;
    }

    final int MAX = 1000000000;
    public int minValidStrings(String[] words, String target) {

        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

        int n = target.length();
        int[]dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == MAX) {
                continue;
            }
            List<Integer>res = search(root, target, i);
            for (Integer len : res) {
                dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
            }
        }

        if (dp[n] == MAX) {
            return -1;
        }
        return dp[n];
    }

    public static void main(String[] args) {

        String[]words = {"abc","aaaaa","bcdef"};
        String target = "aabcdabc";

        Solution sol = new Solution();
        int ret = sol.minValidStrings(words, target);

        System.out.println(ret);
    }
}



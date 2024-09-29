package 单词拆分;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public boolean isValid(String s, String t, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != t.charAt(i - start)) {
                return false;
            }
        }
        return true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[]dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                int len = word.length();

                if (j - len >= 0) {
                    if (isValid(s, word, j - len, j - 1) && dp[j - len]) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        Solution sol = new Solution();
        boolean ret = sol.wordBreak(s, wordDict);

        System.out.println(ret);
    }
}



package 最长回文子串;

class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();
        if (n == 1) {
            return s;
        }

        boolean[][]dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0, maxLen = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        int curLen = j - i + 1;
                        if (curLen > maxLen) {
                            start = i;
                            maxLen = curLen;
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        int curLen = j - i + 1;
                        if (curLen > maxLen) {
                            start = i;
                            maxLen = curLen;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {

        String s = "aaaa";

        Solution sol = new Solution();
        String ret = sol.longestPalindrome(s);

        System.out.println(ret);
    }
}



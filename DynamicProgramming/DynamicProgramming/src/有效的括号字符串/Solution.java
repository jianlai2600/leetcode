package 有效的括号字符串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkValidString(String s) {

        int n = s.length();
        boolean[][]dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    if (s.charAt(i) == '*') {
                        dp[i][j] = true;
                    }
                } else if (j == i + 1) {
                    String subS = s.substring(i, j + 1);
                    if (subS.equals("(*") || subS.equals("*)") || subS.equals("**") || subS.equals("()")) {
                        dp[i][j] = true;
                    }
                } else {
                    if ((s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(j) == ')' || s.charAt(j) == '*')) {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            continue;
                        }
                    }
                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
    public static void main(String[] args) {

        String s = "(*))";

        Solution sol = new Solution();
        boolean ret = sol.checkValidString(s);

        System.out.println(ret);
    }
}
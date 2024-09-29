package 分割回文串2;

class Solution {

    public boolean isValid(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int minCut(String s) {

        int n = s.length();
        int[]dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (isValid(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isValid(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        String s = "aab";

        Solution sol = new Solution();
        int ret = sol.minCut(s);

        System.out.println(ret);
    }
}



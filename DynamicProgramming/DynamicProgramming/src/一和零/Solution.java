package 一和零;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][]dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            // Calculate 0 and 1
            int numOne = 0, numZero = 0;
            for (Character c : strs[i].toCharArray()) {
                if (c == '0') {
                    numZero++;
                } else {
                    numOne++;
                }
            }
            /**
             * 本题中strs 数组里的元素就是物品，每个物品都是一个！
             * 而m和n相当于是一个背包，两个维度的背包。
             */
            for (int j = m; j >= numZero; j--) {
                for (int k = n; k >= numOne; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numZero][k - numOne] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args)
    {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

        Solution sol = new Solution();
        int ret = sol.findMaxForm(strs, m, n);

        System.out.println(ret);
    }
}



package AM_getMinServer;

public class Solution {
    public static int getMin(String serverType) {
        if (serverType == null || serverType.length() <= 1) {
            return 0;
        }

        int n = serverType.length();
        // dp[i][j] 表示前i个位置，第i个位置使用j（0或1）时的最小不连续数
        int[][] dp = new int[n][2];

        // 初始化第一个位置
        dp[0][0] = 0;
        dp[0][1] = 0;

        // 填充dp数组
        for (int i = 1; i < n; i++) {
            char curr = serverType.charAt(i);
            char prev = serverType.charAt(i-1);

            // 处理当前位置是'?'的情况
            if (curr == '?') {
                if (prev == '?') {
                    // 前一个位置是'?'，需要考虑前一个位置的两种可能
                    // 当前位置放0
                    dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1] + 1);
                    // 当前位置放1
                    dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0] + 1);
                } else {
                    // 前一个位置是确定的
                    int prevVal = prev - '0';
                    // 当前位置放0
                    dp[i][0] = dp[i-1][prevVal] + (prevVal != 0 ? 1 : 0);
                    // 当前位置放1
                    dp[i][1] = dp[i-1][prevVal] + (prevVal != 1 ? 1 : 0);
                }
            }
            // 处理当前位置是确定值的情况
            else {
                int currVal = curr - '0';
                if (prev == '?') {
                    if (currVal == 0) {
                        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1] + 1);
                    } else { // currVal == 1
                        dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0] + 1);
                    }
                } else {
                    // 前一个位置也是确定的
                    int prevVal = prev - '0';
                    dp[i][currVal] = dp[i-1][prevVal] + (prevVal != currVal ? 1 : 0);
                }
            }
        }

        // 获取最后一个位置的最优解
        char last = serverType.charAt(n-1);
        if (last == '?') {
            return Math.min(dp[n-1][0], dp[n-1][1]);
        } else {
            return dp[n-1][last - '0'];
        }
    }

    public static void main(String[] args) {
        // 测试用例
        String[] tests = {
                "??011??0",  // 预期输出: 2
                "?001001",   // 预期输出: 3
                "???",       // 预期输出: 0
                "0?1?0"      // 预期输出: 2
        };

        for (String test : tests) {
            System.out.printf("Input: %s, Minimum inefficiency: %d%n",
                    test, getMin(test));
        }
    }
}
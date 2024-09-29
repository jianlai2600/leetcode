package 背包问题;

class Solution {
    // 背包问题，物体->背包（01背包，从大到小）（完全背包，从小到大）

    // 0-1背包问题，先遍历物品，再遍历重量
    // 二维dp写法
    public int bagQuestion(int[]weights, int[]values, int sum) {

        int m = weights.length;
        int[][]dp = new int[m][sum + 1];

        // 初始化
        for (int j = weights[0]; j <= sum; j++) {
            dp[0][j] = values[0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - weights[i] >= 0) {
                    // j >= weights[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    // j < weights[i]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][sum];
    }

    // 滚动数组dp写法
    public int bagQuestionRolling(int[]weights, int[]values, int sum) {

        int m = weights.length;
        int[]dp = new int[sum + 1];

        // 倒序遍历是为了保证物品i只被放入一次！
        for (int i = 0; i < m; i++) {
            for (int j = sum; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[sum];
    }

    // 完全背包 第二层从小往大遍历背包容量
    // 滚动数组dp写法
    public int bagQuestionAbsolute(int[]weights, int[]values, int sum) {

        int m = weights.length;
        int[]dp = new int[sum + 1];

        // 正序遍历是为了保证物品i可以被放入多次！
        for (int i = 0; i < m; i++) {
            for (int j = weights[i]; j <= sum; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {

        int[] weights = {1, 3, 4};
        int sum = 4;
        int[] values = {15, 20, 30};

        Solution sol = new Solution();
        int ret = sol.bagQuestionAbsolute(weights, values, sum);

        System.out.println(ret);
    }
}



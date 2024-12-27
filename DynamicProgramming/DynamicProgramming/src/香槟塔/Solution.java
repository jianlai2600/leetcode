package 香槟塔;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][]dp = new double[query_row + 2][query_row + 2];

        dp[0][0] = poured;
        for (int i = 0; i < query_row + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (dp[i][j] > 1) {
                    double more = dp[i][j] - 1;
                    dp[i][j] = 1;
                    dp[i + 1][j] = more / 2 + dp[i + 1][j];
                    dp[i + 1][j + 1] = more / 2 + dp[i + 1][j + 1];
                }
            }
        }

        return dp[query_row][query_glass];
    }

    public static void main(String[] args) {

        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;

        Solution sol = new Solution();
        double ret = sol.champagneTower(poured, query_row, query_glass);

        System.out.println(ret);
    }
}



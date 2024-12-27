package 骑士在棋盘上的概率;

import java.util.*;

class Solution {
    int[][]directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, 1}, {2, -1}};
    public double knightProbability2(int n, int k, int row, int column) {

        if (k == 0) {
            return 1;
        }
        double sumCnt = Math.pow(8, k);

        Queue<int[]>queue = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            queue.add(new int[]{row + directions[i][0], column + directions[i][1]});
        }

        int cnt = 0;

        for (int i = 0; i < k; i++) {

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] arr = queue.poll();
                int x = arr[0], y = arr[1];

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (i == k - 1) {
                        cnt++;
                    }
                    for (int[] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return (double)cnt / sumCnt;
    }

    public double knightProbability(int n, int k, int row, int column) {

        double[][][]dp = new double[k + 1][n][n];

        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : directions) {
                            int newX = i + dir[0];
                            int newY = j + dir[1];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                                dp[step][i][j] += dp[step - 1][newX][newY] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
    public static void main(String[] args) {

        int n = 1, k = 0, row = 0, column = 0;

        Solution sol = new Solution();
        double ret = sol.knightProbability(n, k, row, column);

        System.out.println(ret);
    }
}
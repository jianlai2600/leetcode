package 矩阵01;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    int[][]directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[][]result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length) {
                    if (result[newX][newY] > result[x][y] + 1) {
                        result[newX][newY] = result[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        Solution sol = new Solution();
        int[][]result = sol.updateMatrix(mat);

        for (int[]row : result) {
            for (int room : row) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
}



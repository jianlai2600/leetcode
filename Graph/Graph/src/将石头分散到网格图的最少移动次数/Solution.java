package 将石头分散到网格图的最少移动次数;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int res;
    int size;
    int tmp = 0;
    public void find(List<int[]>list, int[][] grid, int index) {

        if (index == size) {
            res = Math.min(res, tmp);
            return;
        }

        int cx = list.get(index)[0], cy = list.get(index)[1];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {

                    grid[i][j] = grid[i][j] - 1;
                    grid[cx][cy] = 1;
                    tmp += Math.abs(i - cx) + Math.abs(j - cy);

                    find(list, grid, index + 1);

                    tmp -= Math.abs(i - cx) + Math.abs(j - cy);
                    grid[i][j] = grid[i][j] + 1;
                    grid[cx][cy] = 0;

                }
            }
        }
    }
    public int minimumMoves(int[][] grid) {

        res = Integer.MAX_VALUE;
        List<int[]>list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        size = list.size();
        find(list, grid, 0);

        return res;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 2, 1}
        };

        Solution sol = new Solution();
        int res = sol.minimumMoves(grid);

        System.out.println(res);
    }
}



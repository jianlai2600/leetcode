package NeighborSum;

import java.util.HashMap;
import java.util.Map;

class NeighborSum {

    int[][]adjacent = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][]diagonal = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    int[][]matrix;
    int m, n;
    Map<Integer, int[]> map;
    public NeighborSum(int[][] grid) {

        matrix = grid;
        m = matrix.length;
        n = matrix[0].length;

        map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[]tmp = new int[2];
                tmp[0] = i;
                tmp[1] = j;
                map.put(matrix[i][j], tmp);
            }
        }
    }

    public int adjacentSum(int value) {

        int sum = 0;
        int[]tmp = map.get(value);

        int x = tmp[0];
        int y = tmp[1];

        for (int i = 0; i < 4; i++) {
            int nx = x + adjacent[i][0];
            int ny = y + adjacent[i][1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                sum += matrix[nx][ny];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {

        int sum = 0;
        int[]tmp = map.get(value);

        int x = tmp[0];
        int y = tmp[1];

        for (int i = 0; i < 4; i++) {
            int nx = x + diagonal[i][0];
            int ny = y + diagonal[i][1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                sum += matrix[nx][ny];
            }
        }
        return sum;
    }
}
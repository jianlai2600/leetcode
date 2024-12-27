package ObstacleSolution;

import java.util.HashSet;
import java.util.Set;

public class ObstacleSolution {
    public static int solution(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<int[]> obs = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    obs.add(tmp);
                }
            }
        }

        if (obs.isEmpty()) {
            return 0;
        }

        int minObstacles = 0;

        int row = -1;
        for (int i = rows - 1; i >= 0; i--) {
            boolean find = false;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    row = i;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        int diff = rows - 1 - row;

        for (int[] tmp : obs) {
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 1; i <= diff; i++) {
                int nx = x - i;
                if (nx < 0) { // 防止数组越界
                    break;
                }
                if (board[nx][y] == '*') {
                    minObstacles++;
                    break;
                }
            }
        }

        return minObstacles;
    }
    public static void main(String[] args) {
        // 示例测试用例 1
        char[][] board1 = {
                {'*', '*', '*'},
                {'*', '#', '*'},
                {'*', '#', '*'},
                {'.', '#', '.'}
        };

        // 示例测试用例 2
        char[][] board2 = {
                {'#', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '#', '.', '.', '.'},
                {'.', '.', '.', '.', '*'}
        };

        // 示例测试用例 3
        char[][] board3 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '*'}
        };

        // 调用 solution 并输出结果
        System.out.println("Test Case 1: " + solution(board1)); // 预期结果：1
        System.out.println("Test Case 2: " + solution(board2)); // 预期结果：2
        System.out.println("Test Case 3: " + solution(board3)); // 预期结果：0
    }
}

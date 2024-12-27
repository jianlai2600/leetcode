package 扫雷游戏;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m, n;
    int[]square = {-1, 0, 1};
    boolean[][]visited;
    public int getNum(char[][]board, int x, int y) {

        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x + square[i];
                int ny = y + square[j];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (board[nx][ny] == 'M') {
                    res++;
                }
            }
        }
        return res;
    }
    // BFS
    public void bfs(char[][]board, int x, int y) {

        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        int roundNum = getNum(board, x, y);
        if (roundNum == 0) {
            board[x][y] = 'B';

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nx = x + square[i];
                    int ny = y + square[j];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    bfs(board, nx, ny);
                }
            }

        } else {
            board[x][y] = Character.forDigit(roundNum, 10);
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];
        bfs(board, x, y);

        return board;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };

        // 点击位置的坐标
        int[] click = {3, 0};

        Solution sol = new Solution();
        char[][]res = sol.updateBoard(board, click);

        for (char[]row : res) {
            for (char room : row) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}



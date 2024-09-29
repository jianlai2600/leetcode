package 被围绕的区域;


class Solution {
    // DFS
    public void dfs(char[][]grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        if (grid[x][y] == 'X' || grid[x][y] == 'T') {
            return;
        }

        grid[x][y] = 'T';
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
    }
    public void solve(char[][] board) {

        int ret = 0;
        int m = board.length, n = board[0].length;

        /**
         * Boundry O->T
         */
        for (int j = 0; j < n; j++) {
             dfs(board, 0, j);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, n - 1);
        }

        /**
         * Iner O->X
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        /**
         * T->O
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };

        Solution sol = new Solution();
        sol.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}



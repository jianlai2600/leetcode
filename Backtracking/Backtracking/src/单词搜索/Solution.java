package 单词搜索;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (m * n < word.length())return false;

        boolean[][]visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                boolean flag = backtracking(i, j, board, visited, word, 0);
                if (flag)return true;
            }
        }
        return false;
    }

    public boolean backtracking(int row, int col, char[][]board, boolean[][]visited, String word, int k) {

        if (board[row][col] != word.charAt(k))return false;
        else if (k == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        int[][]directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean ret = false;

        for (int[]dir : directions)
        {
            int newrow = row + dir[0];
            int newcol = col + dir[1];
            if (newrow >= 0 && newrow < board.length && newcol >= 0 && newcol < board[0].length)
            {
                if (visited[newrow][newcol] == false)
                {
                    boolean flag = backtracking(newrow, newcol, board, visited, word, k + 1);
                    if (flag)
                    {
                        ret = true;
                        break;
                    }
                }
            }
        }

        visited[row][col] = false;
        return ret;
    }
    public static void main(String[] args)
    {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        Solution sol = new Solution();
        boolean ret = sol.exist(board, word);

        System.out.println("Boolean: " + ret);
    }
}
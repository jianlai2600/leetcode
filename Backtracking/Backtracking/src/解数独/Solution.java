package 解数独;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValid(char[][] board, int row, int col, char numChar) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == numChar || board[i][col] == numChar) {
                return false;
            }
        }

        int blockRow = row / 3, blockCol = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + blockRow * 3][j + blockCol * 3] == numChar) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean backTracking(char[][] board, int row, int col) {

        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return backTracking(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            // encounter digit
            return backTracking(board, row, col + 1);
        } else {
            // normal process
            for (char numChar = '1'; numChar <= '9'; numChar++) {
                if (isValid(board, row, col, numChar)) {
                    board[row][col] = numChar;
                    if (backTracking(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }
    }
    public void solveSudoku(char[][] board) {

        backTracking(board, 0, 0);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution sol = new Solution();
        sol.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
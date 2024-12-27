package 可以被一步捕获的棋子数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numRookCaptures(char[][] board) {

        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int count = 0;

        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'p') {
                count++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x; i < 8; i++) {
            if (board[i][y] == 'p') {
                count++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'p') {
                count++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y; i < 8; i++) {
            if (board[x][i] == 'p') {
                count++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }

        return count;
    }
    public static void main(String[] args) {

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        Solution sol = new Solution();
        int ret = sol.numRookCaptures(board);

        System.out.println(ret);
    }
}
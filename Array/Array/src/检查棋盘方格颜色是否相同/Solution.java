package 检查棋盘方格颜色是否相同;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {

        int c1 = coordinate1.charAt(0) - 'a' + 1 + coordinate1.charAt(1) - '1' + 1;
        int c2 = coordinate2.charAt(0) - 'a' + 1 + coordinate2.charAt(1) - '1' + 1;

        return c1 % 2 == c2 % 2;
    }
    public static void main(String[] args) {

        String coordinate1 = "a1", coordinate2 = "c3";

        Solution sol = new Solution();
        boolean ret = sol.checkTwoChessboards(coordinate1, coordinate2);

        System.out.println(ret);
    }
}
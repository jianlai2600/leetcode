package 判断国际象棋棋盘中一个格子的颜色;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean squareIsWhite(String coordinates) {

        int num1 = coordinates.charAt(0) - 'a' + 1;
        int num2 = coordinates.charAt(1) - '0';

        return num1 % 2 != num2 % 2;
    }
    public static void main(String[] args) {

        String coordinates = "c7";

        Solution sol = new Solution();
        boolean ret = sol.squareIsWhite(coordinates);

        System.out.println(ret);
    }
}
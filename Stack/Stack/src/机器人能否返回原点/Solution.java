package 机器人能否返回原点;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public boolean judgeCircle(String moves) {

        int up = 0, down = 0, left = 0, right = 0;

        for (Character c : moves.toCharArray()) {
            if (c.equals('D')) {
                down++;
            } else if (c.equals('U')) {
                up++;
            } else if (c.equals('L')) {
                left++;
            } else {
                right++;
            }
        }
        return up == down && left == right;
    }

    public static void main(String[] args) {

        String moves = "UD";

        Solution sol = new Solution();
        boolean ret = sol.judgeCircle(moves);

        System.out.println(ret);
    }
}
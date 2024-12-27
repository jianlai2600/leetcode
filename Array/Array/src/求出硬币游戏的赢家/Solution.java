package 求出硬币游戏的赢家;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String losingPlayer(int x, int y) {

        int alice = 1;

        while (x > 0 && y > 0) {
            if (x >= 1 && y >= 4) {
                x -= 1;
                y -= 4;
                alice *= -1;
            } else {
                break;
            }
        }
        return alice == 1 ? "Bob" : "Alice";
    }
    public static void main(String[] args) {

        Solution sol = new Solution();
        String res = sol.losingPlayer(2, 10);

        System.out.println(res);
    }
}
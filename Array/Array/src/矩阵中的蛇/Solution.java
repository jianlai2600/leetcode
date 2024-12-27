package 矩阵中的蛇;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {

        int i = 0, j = 0;
        for (String command : commands) {
            switch (command) {
                case "UP" -> i--;
                case "DOWN" -> i++;
                case "LEFT" -> j--;
                case null, default -> j++;
            }
        }
        return (i * n) + j;
    }
    public static void main(String[] args) {

        int n = 2;
        List<String> commands = new ArrayList<>();
        commands.add("RIGHT");
        commands.add("DOWN");

        Solution sol = new Solution();
        int res = sol.finalPositionOfSnake(n, commands);

        System.out.println(res);
    }
}
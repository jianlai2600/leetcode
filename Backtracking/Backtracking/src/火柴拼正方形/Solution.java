package 火柴拼正方形;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean backtracking(int[] matchsticks, int index, int[]arr) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {

            arr[i] += matchsticks[index];

            if (arr[i] <= target && backtracking(matchsticks, index + 1, arr)) {
                return true;
            }
            arr[i] -= matchsticks[index];
        }
        return false;
    }
    int target;
    int curSum;
    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for (Integer match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0) {
            return false;
        }

        target = sum / 4;

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[]arr = new int[4];
        return backtracking(matchsticks, 0, arr);
    }

    public static void main(String[] args) {

        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};

        Solution sol = new Solution();
        boolean res = sol.makesquare(matchsticks);

        System.out.println(res);
    }

}
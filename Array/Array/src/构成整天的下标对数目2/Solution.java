package 构成整天的下标对数目2;

import java.util.*;

class Solution {
    public long countCompleteDayPairs(int[] hours) {

        long[]map = new long[24];
        long res = 0;

        for (Integer hour : hours) {
            int tmp = hour % 24;

            int need = (24 - tmp) % 24;

            res += map[need];

            map[tmp]++;

        }

        return res;
    }
    public static void main(String[] args) {

        int[] hours = {12,12,30,24,24};

        Solution sol = new Solution();
        long ret = sol.countCompleteDayPairs(hours);

        System.out.println(ret);
    }
}
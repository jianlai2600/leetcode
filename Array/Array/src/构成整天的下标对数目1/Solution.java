package 构成整天的下标对数目1;

import java.util.*;

class Solution {
    public int countCompleteDayPairs(int[] hours) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (Integer hour : hours) {
            int tmp = hour % 24;

            int need = (24 - tmp) % 24;
            if (map.containsKey(need)) {
                res += map.get(need);
            }

            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }

        }

        return res;
    }
    public static void main(String[] args) {

        int[] hours = {12,12,30,24,24};

        Solution sol = new Solution();
        int ret = sol.countCompleteDayPairs(hours);

        System.out.println(ret);
    }
}
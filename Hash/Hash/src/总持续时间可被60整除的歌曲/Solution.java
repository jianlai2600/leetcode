package 总持续时间可被60整除的歌曲;

import java.util.*;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int ret = 0;

        Map<Integer, Integer>map = new HashMap<>();
        Set<Integer>set = new HashSet<>();

        for (Integer num : time) {

            int residual = num % 60;
            int need = (60 - residual) % 60;

            if (set.contains(need)) {
                ret += map.get(need);
            }
            map.put(residual, map.getOrDefault(residual, 0) + 1);

            set.add(residual);
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]time = {60, 60, 60};

        Solution sol = new Solution();
        int ret = sol.numPairsDivisibleBy60(time);

        System.out.println(ret);
    }
}




package 数组的度;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer>frequency = new HashMap<>();
        Map<Integer, int[]>range = new HashMap<>();

        int maxFre = 0;
        int index = 0;
        for (Integer num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            maxFre = Math.max(maxFre, frequency.get(num));

            if (range.containsKey(num)) {
                int[]tmp = range.get(num);
                tmp[1] = index;
                range.put(num, tmp);
            } else {
                int[]tmp = new int[2];
                tmp[0] = index;
                tmp[1] = -1;
                range.put(num, tmp);
            }
            index++;
        }

        int res = Integer.MAX_VALUE;

        for (Integer key : frequency.keySet()) {
            if (frequency.get(key) == maxFre) {
                int[]tmp = range.get(key);
                int f = 1;
                if (tmp[1] != -1) {
                    f = tmp[1] - tmp[0] + 1;
                }
                res = Math.min(res, f);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1};

        Solution sol = new Solution();
        int res = sol.findShortestSubArray(nums);

        System.out.println(res);
    }
}




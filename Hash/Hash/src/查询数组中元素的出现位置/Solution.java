package 查询数组中元素的出现位置;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                map.put(index, i);
                index++;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int key = queries[i];
            if (map.containsKey(key)) {
                result[i] = map.get(key);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[]nums = {1,3,1,7}, queries = {1,3,2,4};
        int x = 1;

        Solution sol = new Solution();
        int[]result = sol.occurrencesOfElement(nums, queries, x);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}




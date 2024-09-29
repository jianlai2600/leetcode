package 独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : arr) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        Set<Integer>set = new HashSet<>();

        for (Integer value : map.values()) {
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,1,1,3};

        Solution sol = new Solution();
        boolean ret = sol.uniqueOccurrences(nums);

        System.out.println(ret);
    }
}
package 随机数索引;

import java.util.*;

class Solution {
    Map<Integer, List<Integer>>map;
    public Solution(int[] nums) {

        map = new HashMap<>();
        int index = 0;
        for (Integer num : nums) {
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(index++);
        }
    }

    public int pick(int target) {

        List<Integer>list = map.get(target);
        int n = list.size();

        Random rand = new Random();
        int roll = rand.nextInt(n);

        return list.get(roll);
    }
}
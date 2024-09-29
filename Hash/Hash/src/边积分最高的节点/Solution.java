package 边积分最高的节点;

import java.util.*;

class Solution {
    public int edgeScore(int[] edges) {

        Map<Integer, Long>map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i];
            map.put(node, map.getOrDefault(node, (long)0) + i);
        }

        int ret = 0;
        long maxValue = 0;

        for (Integer key : map.keySet()) {
            long value = map.get(key);
            if (value > maxValue || value == maxValue && key < ret) {
                maxValue = value;
                ret = key;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]edges = {1,0,0,0,0,7,7,5};

        Solution sol = new Solution();
        int ret = sol.edgeScore(edges);

        System.out.println(ret);
    }
}




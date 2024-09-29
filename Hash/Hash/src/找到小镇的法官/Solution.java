package 找到小镇的法官;

import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {

        int ret = -1;

        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }

        Map<Integer, Integer>map = new HashMap<>();
        int[]count = new int[n + 1];

        for (int[]relation : trust) {
            int source = relation[0];
            int target = relation[1];
            count[source]++;
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == n - 1 && count[key] == 0) {
                return key;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[][] trust = {{1, 3}, {2, 3}};
        int n = 3;

        Solution sol = new Solution();
        int ret = sol.findJudge(n, trust);

        System.out.println(ret);
    }
}




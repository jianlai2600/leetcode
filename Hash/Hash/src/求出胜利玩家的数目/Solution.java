package 求出胜利玩家的数目;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {

        Map<Integer, Integer>[]map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }

        int res = 0;

        for (int[]p : pick) {
            int player = p[0];
            int ball = p[1];
            Map<Integer, Integer>submap = map[player];
            submap.put(ball, submap.getOrDefault(ball, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer>submap = map[i];
            for (Integer key : submap.keySet()) {
                int value = submap.get(key);
                if (value > i) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int n = 4;
        int[][] pick = {
                {0, 0},
                {1, 0},
                {1, 0},
                {2, 1},
                {2, 1},
                {2, 0}
        };

        Solution sol = new Solution();
        int res = sol.winningPlayerCount(n, pick);

        System.out.println(res);
    }
}




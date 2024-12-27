package 图中最大星和;

import java.util.*;

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {

        PriorityQueue<Integer>pq;
        Map<Integer, Set<Integer>>map = new HashMap<>();

        for (int[]edge : edges) {
            int s = edge[0];
            int t = edge[1];
            Set<Integer>set1 = map.getOrDefault(s, new HashSet<>());
            set1.add(t);
            map.put(s, set1);
            Set<Integer>set2 = map.getOrDefault(t, new HashSet<>());
            set2.add(s);
            map.put(t, set2);
        }

        int res = Integer.MIN_VALUE;
        int n = vals.length;

        for (int i = 0; i < n; i++) {
            Set<Integer>neighbors = map.getOrDefault(i, new HashSet<>());
            pq = new PriorityQueue<>((a, b)->b - a);

            if (neighbors.isEmpty()) {
                res = Math.max(res, vals[i]);
                continue;
            }
            for (Integer neighbor : neighbors) {
                pq.add(vals[neighbor]);
            }
            int sum = vals[i];
            if (sum > res) {
                res = sum;
            }
            for (int j = 0; j < k; j++) {
                if (pq.isEmpty()) {
                    break;
                }
                sum += pq.poll();
                if (sum > res) {
                    res = sum;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[]vals = {1,2,3,4,10,-10,-20};
        int[][]edges = {{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}};
        int k = 2;

        Solution sol = new Solution();

        int ret = sol.maxStarSum(vals, edges, k);

        System.out.println(ret);
    }
}

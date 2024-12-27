package 可能的二分法;


import java.util.*;

class Solution {
    int[]unionFind;
    public boolean possibleBipartition(int n, int[][] dislikes) {

        unionFind = new int[n];
        List<Integer>[]graph = new List[n];

        unionFind = new int[n];
        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            int src = dislikes[i][0] - 1;
            int dst = dislikes[i][1] - 1;
            graph[src].add(dst);
            graph[dst].add(src);
        }

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                if (find(i) == find(j)) {
                    return false;
                }
                unionFind[j] = find(graph[i].get(0));
            }
        }

        return true;
    }
    public int find(int x) {

        if (unionFind[x] != x) {
            unionFind[x] = find(unionFind[x]);
        }
        return unionFind[x];
    }
    public static void main(String[] args) {

        int n = 9;
        int[][] dislikes = {{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}};

        Solution sol = new Solution();
        boolean ret = sol.possibleBipartition(n, dislikes);

        System.out.println(ret);
    }
}



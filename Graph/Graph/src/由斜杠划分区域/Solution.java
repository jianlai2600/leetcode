package 由斜杠划分区域;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class UnionFind {

        private int[] parent;
        int cnt;
        public UnionFind(int n) {
            this.parent = new int[n];
            this.cnt = n;

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            } else {
                parent[rootX] = rootY;
                cnt--;
            }
        }
    }
    public int regionsBySlashes(String[] grid) {

        int n = grid.length;
        UnionFind unionFind = new UnionFind(n * n * 4);

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];

                int index = (i * n + j) * 4;
                if (c == '/') {
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }
                if (i < n - 1) {
                    unionFind.union(index + 2, ((i + 1) * n + j) * 4);
                }
                if (j < n - 1) {
                    unionFind.union(index + 1, (i * n + j + 1) * 4 + 3);
                }
            }
        }
        return unionFind.cnt;
    }
    public static void main(String[] args) {

        String[] grid = {"/\\","\\/"};

        Solution sol = new Solution();
        int res = sol.regionsBySlashes(grid);

        System.out.println(res);
    }
}



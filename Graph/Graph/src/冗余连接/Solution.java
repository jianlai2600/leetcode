package 冗余连接;

class Solution {
    class ufs {
        int[]father;
        ufs(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        private int find(int element) {
            if (element != father[element]) {
                father[element] = find(father[element]);
            }
            return father[element];
        }
        public void join(int point1, int point2) {

            int f1 = find(point1);
            int f2 = find(point2);

            if (f1 != f2) {
                father[f2] = f1;
            }
        }
        public boolean isConnected(int point1, int point2) {
            return find(point1) == find(point2);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        int n = 0;
        for (int[]edge : edges) {
            n = Math.max(Math.max(n, edge[0]), edge[1]);
        }
        ufs u = new ufs(n + 1);

        for (int[]edge : edges) {
            if (!u.isConnected(edge[0], edge[1])) {
                u.join(edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};

        Solution sol = new Solution();
        int[] ret = sol.findRedundantConnection(edges);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



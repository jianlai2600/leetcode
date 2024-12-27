package 引爆最多的炸弹;


import java.util.*;

class Solution {
    int tmp;
    public boolean isConnected(int[][] bombs, int node1, int node2) {

        int x1 = bombs[node1][0];
        int y1 = bombs[node1][1];
        int x2 = bombs[node2][0];
        int y2 = bombs[node2][1];
        int r = bombs[node1][2];

        int xAbs = Math.abs(x1 - x2);
        int yAbs = Math.abs(y1 - y2);

        long xSquare = (long) xAbs * (long) xAbs;
        long ySquare = (long) yAbs * (long) yAbs;
        long rSquare = (long) r * (long) r;

        if (rSquare - xSquare >= ySquare) {
            return true;
        }
        return false;
    }
    public void bfs(int[][]bombs, List<List<Integer>>map, int index) {

        Queue<Integer>queue = new LinkedList<>();
        Set<Integer>set = new HashSet<>();

        queue.add(index);
        set.add(index);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                tmp++;
                List<Integer>neighbors = map.get(curNode);

                for (Integer neighbor : neighbors) {
                    if (!set.contains(neighbor)) {
                        queue.add(neighbor);
                        set.add(neighbor);
                    }
                }
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {

        int res = 0;
        //
        List<List<Integer>>map = new ArrayList<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            List<Integer>tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (isConnected(bombs, i, j)) {
                        tmp.add(j);
                    }
                }
            }
            map.add(tmp);
        }
        //
        for (int i = 0; i < n; i++) {
            tmp = 0;
            bfs(bombs, map, i);
            if (tmp > res) {
                res = tmp;
            }
        }
        //

        return res;
    }

    public static void main(String[] args) {

        int[][] bombs = {
                {2, 1, 3},
                {6, 1, 4}
        };

        Solution sol = new Solution();
        int res = sol.maximumDetonation(bombs);

        System.out.println(res);
    }
}



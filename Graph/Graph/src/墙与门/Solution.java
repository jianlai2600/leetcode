package 墙与门;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    int m, n;
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][]visited;
    // BFS
    public void bfs(boolean[][]visited, int[][]rooms, int x, int y) {

        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int dist = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int[]tmp = queue.poll();
                x = tmp[0];
                y = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (rooms[nx][ny] != -1 && rooms[nx][ny] != 0 && !visited[nx][ny]) {

                        rooms[nx][ny] = Math.min(dist, rooms[nx][ny]);
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            dist++;
        }
    }
    public void wallsAndGates(int[][] rooms) {

        m = rooms.length;
        n = rooms[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    visited = new boolean[m][n];
                    bfs(visited, rooms, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {

        int rooms[][] = {{INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}};

        Solution sol = new Solution();
        sol.wallsAndGates(rooms);

        for (int[]row : rooms) {
            for (int room : row) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
}



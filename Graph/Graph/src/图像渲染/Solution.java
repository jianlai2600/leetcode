package 图像渲染;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][]dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int source = image[sr][sc];
        if (source == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            image[x][y] = color;

            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == source) {
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        Solution sol = new Solution();
        int[][]res = sol.floodFill(image, sr, sc, color);

        for (int[]row : res) {
            for (int room : row) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
}



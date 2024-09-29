package 螺旋矩阵2;

class Solution {
    public int[][] generateMatrix(int n) {

        int[][]ret = new int[n][n];

        int len = n - 1, num = 1;
        int cnt = 0;
        while (len >= 1) {

            for (int i = 0; i < len; i++) {
                ret[cnt][cnt + i] = num++;
            }
            for (int i = 0; i < len; i++) {
                ret[cnt + i][n - 1 - cnt] = num++;
            }
            for (int i = 0; i < len; i++) {
                ret[n - 1 - cnt][n - 1 - cnt - i] = num++;
            }
            for (int i = 0; i < len; i++) {
                ret[n - 1 - cnt - i][cnt] = num++;
            }

            cnt++;
            len -= 2;
        }

        if (n % 2 == 1) {
            ret[n / 2][n / 2] = n * n;
        }
        return ret;
    }
    public static void main(String[] args) {

        int n = 3;

        Solution sol = new Solution();
        int[][] ret = sol.generateMatrix(n);

        for (int[] row : ret){
            for (Integer item : row){
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
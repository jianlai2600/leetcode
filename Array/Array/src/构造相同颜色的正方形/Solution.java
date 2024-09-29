package 构造相同颜色的正方形;

class Solution {
    public boolean canMakeSquare(char[][] grid) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int count = 0;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        if (grid[i + k][j + l] == 'W') {
                            count++;
                        }
                    }
                }
                if (count != 2) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        char[][] grid = {
                {'B', 'W', 'B'},
                {'B', 'W', 'W'},
                {'B', 'W', 'B'}
        };

        Solution sol = new Solution();
        boolean ret = sol.canMakeSquare(grid);

        System.out.println(ret);
    }
}
package 子矩形查询;

class SubrectangleQueries {

    int[][]arr;
    int m, n;
    public SubrectangleQueries(int[][] rectangle) {

        arr = rectangle;
        m = arr.length;
        n = arr[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                arr[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {

        return arr[row][col];
    }
}
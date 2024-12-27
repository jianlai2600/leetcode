package 根据第K场考试的分数排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(new int[]{score[i][k], i});
        }
        list.sort((a, b)->{return b[0] - a[0];});

        int[][]ret = new int[score.length][score[0].length];
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i)[1];
            ret[i] = score[index];
        }
        return ret;
    }
    public static void main(String[] args) {

        // 初始化二维数组 score
        int[][] score = {
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}
        };

        // 初始化变量 k
        int k = 2;

        Solution sol = new Solution();
        int[][]ret = sol.sortTheStudents(score, k);

        System.out.println(Arrays.deepToString(ret));
    }
}
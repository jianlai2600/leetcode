package 区间列表的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstPointer = 0, secondPointer = 0;
        int m = firstList.length, n = secondList.length;
        List<int[]>ans = new ArrayList<>();
        //

        while (firstPointer < m && secondPointer < n) {

            int[]fp = firstList[firstPointer];
            int[]sp = secondList[secondPointer];

            int left = Math.max(fp[0], sp[0]);
            int right = Math.min(fp[1], sp[1]);

            if (left <= right) {
                ans.add(new int[]{left, right});
            }

            if (fp[1] <= sp[1]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args)
    {
        int[][]firstList = {{0,2},{5,10},{13,23},{24,25}}, secondList = {{1,5},{8,12},{15,24},{25,26}};

        Solution sol = new Solution();
        int[][]ret = sol.intervalIntersection(firstList, secondList);

        for (int[]intersection : ret) {
            for (Integer num : intersection) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

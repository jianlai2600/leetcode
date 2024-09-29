package 最接近原点的K个点;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        List<int[]>ret = new ArrayList<>();
        for (int[]point : points) {
            ret.add(point);
        }

        Collections.sort(ret, (o1, o2) -> {
            double dis1 = Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]);
            double dis2 = Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]);
            return dis1 - dis2 <= 0 ? -1 : 1;
        });

        ret = ret.subList(0, k);
        int[][]ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[][]points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        Solution sol = new Solution();
        int[][]ret = sol.kClosest(points, k);

        for (int[]point : ret) {
            for (Integer num : point) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
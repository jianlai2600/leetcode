package 切蛋糕的最小总开销;

import java.util.Arrays;

class Solution {

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        int horizontalIndex = m - 2;
        int verticalIndex = n - 2;

        long cost = 0;
        int hCut = 0, vCut = 0;

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        while (horizontalIndex >= 0 && verticalIndex >= 0) {
            if (horizontalCut[horizontalIndex] > verticalCut[verticalIndex]) {
                cost += (vCut + 1) * horizontalCut[horizontalIndex];
                hCut++;
                horizontalIndex--;
            } else {
                cost += (hCut + 1) * verticalCut[verticalIndex];
                vCut++;
                verticalIndex--;
            }
        }
        while (horizontalIndex >= 0) {
            cost += (vCut + 1) * horizontalCut[horizontalIndex];
            hCut++;
            horizontalIndex--;
        }
        while (verticalIndex >= 0) {
            cost += (hCut + 1) * verticalCut[verticalIndex];
            vCut++;
            verticalIndex--;
        }
        return cost;
    }
    
    public static void main(String[] args) {

        int m = 3, n = 2;
        int[]horizontalCut = {1,3};
        int[]verticalCut = {5};

        Solution sol = new Solution();
        long res = sol.minimumCost(m, n, horizontalCut, verticalCut);

        System.out.println(res);
    }
}


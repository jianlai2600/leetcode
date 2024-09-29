package 按权重随机选择;

import java.util.Random;
class Solution {
    int[]preSum;
    int sum;
    public Solution(int[] w) {

        int n = w.length;
        preSum = new int[n];

        preSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
        sum = preSum[n - 1];
    }

    public int pickIndex() {

        Random rand = new Random();
        int randNum = rand.nextInt(sum);

        int left = 0, right = preSum.length - 1;

        // 二分查找，寻找最近的，小于目标的索引
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (randNum < preSum[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] w = {1};

        Solution sol = new Solution(w);

        System.out.println(sol.pickIndex());
    }
}
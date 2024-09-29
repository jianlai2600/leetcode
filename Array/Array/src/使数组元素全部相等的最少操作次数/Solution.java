package 使数组元素全部相等的最少操作次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int binarySearch(int[]nums, int query) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    public List<Long> minOperations(int[] nums, int[] queries) {

        int n = nums.length;
        Arrays.sort(nums);
        List<Long>res = new ArrayList<>();

        long[]preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 对每一个 query 计算最少操作次数
        for (int query : queries) {
            long sum = 0;
            int index = binarySearch(nums, query);  // 找到小于等于 query 的最大索引

            // 如果所有元素都比 query 大
            if (index == -1) {
                // 全部右边的元素都需要减小为 query
                sum = preSum[n] - (long) query * n;
            } else if (index == n - 1) {
                // 如果所有元素都比 query 小或等于
                sum = (long) query * n - preSum[n];
            } else {
                // 正常情况，分成两部分计算
                long left = (index + 1) * (long) query - preSum[index + 1];
                long right = preSum[n] - preSum[index + 1] - (long) (n - index - 1) * query;

                sum = left + right;
            }

            res.add(sum);
        }

        return res;
    }
    public static void main(String[] args) {

        int[] nums = {3,1,6,8}, queries = {1,5};

        Solution sol = new Solution();
        List<Long> ret = sol.minOperations(nums, queries);

        for (Long l : ret) {
            System.out.print(l + " ");
        }
        System.out.println();
    }
}
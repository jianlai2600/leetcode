package 统计满足K约束的子字符串数量2;

class Solution {
    int n;
    long[]sum;
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {

        int len = queries.length;
        long[]res = new long[len];

        n = s.length();
        int[]left = new int[n];
        int[]cnt = new int[2];

        sum = new long[n + 1];

        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - '0']++;

            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            left[i] = l;
            sum[i + 1] = sum[i] + i - l + 1;
        }

        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ql = queries[i][0];
            int qr = queries[i][1];

            // 使用二分查找找到第一个满足 left[j] >= ql 的位置 j
            int j = findFirstGreaterOrEqual(left, ql, qr, ql);

            // 计算答案的两部分
            long rightPart = sum[qr + 1] - sum[j]; // [j, qr] 区间的子字符串数
            long leftPart = (long) (j - ql) * (j - ql + 1) / 2; // [ql, j-1] 区间的子字符串数

            ans[i] = rightPart + leftPart;
        }
        return ans;
    }
    private int findFirstGreaterOrEqual(int[] nums, int start, int end, int target) {
        // 使用二分查找在 [start, end) 区间内查找第一个 >= target 的位置
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1; // 移动到右半区间
            } else {
                end = mid; // 移动到左半区间
            }
        }
        return start; // 返回第一个 >= target 的位置
    }
    public static void main(String[] args) {

        String s = "0001111";
        int k = 2;
        int[][]queries = {{0,6}};

        Solution sol = new Solution();
        long[]res = sol.countKConstraintSubstrings(s, k, queries);

        for (long num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
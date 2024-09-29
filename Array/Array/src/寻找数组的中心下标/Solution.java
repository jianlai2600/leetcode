package 寻找数组的中心下标;

class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;
        int[]arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] == arr[n] - arr[i]) {
                return i - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[]nums = {1, 7, 3, 6, 5, 6};

        Solution sol = new Solution();
        int ret = sol.pivotIndex(nums);

        System.out.println(ret);
    }
}
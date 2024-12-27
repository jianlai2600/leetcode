package 长度为K的子数组的能量值2;

class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int[]res = new int[n - k + 1];

        int left = 0, right = 0;

        while (left <= n - k) {

            if (right - left == k - 1) {
                res[left] = nums[right];
                left++;
            } else {
                right++;
                while (left <= n - k && left < right && nums[right] != nums[right - 1] + 1) {
                    res[left++] = -1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1, 3, 4};
        int k = 2;

        Solution sol = new Solution();
        int[]res = sol.resultsArray(nums, k);

        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
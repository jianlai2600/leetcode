package 下一个排列;

class Solution {
    public void swap(int[]nums, int left, int right) {

        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int pos = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i;
                break;
            }
        }
        if (pos != 0) {

            int little = pos - 1;
            int big = 0;
            for (int i = pos; i < n; i++) {
                if (nums[i] > nums[little]) {
                    big = i;
                }
            }
            swap(nums, little, big);
        }

        int left = pos, right = n - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {

        int[] nums = {2,2,7,5,4,3,2,2,1};

        Solution sol = new Solution();
        sol.nextPermutation(nums);

        for (Integer i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
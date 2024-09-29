package 移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        Solution sol = new Solution();
        int ret = sol.removeElement(nums, val);

        System.out.println(ret);
    }
}
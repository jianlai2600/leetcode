package 移动零;

class Solution {
    public void moveZeroes(int[] nums) {

        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        Solution sol = new Solution();
        sol.moveZeroes(nums);

        for (Integer item : nums) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
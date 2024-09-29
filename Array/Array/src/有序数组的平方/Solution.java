package 有序数组的平方;

class Solution {
    public int[] sortedSquares(int[] nums) {

        int[]ret = new int[nums.length];

        int left = 0, right = nums.length - 1, ind = nums.length - 1;

        while (left <= right) {
            int numLeft = nums[left] * nums[left];
            int numRight = nums[right] * nums[right];

            if (numLeft > numRight) {
                ret[ind--] = numLeft;
                left++;
            } else {
                ret[ind--] = numRight;
                right--;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};

        Solution sol = new Solution();
        int[] ret = sol.sortedSquares(nums);

        for (Integer item : ret){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
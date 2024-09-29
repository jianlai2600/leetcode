package 按奇偶排序数组2;

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int oddErrorInd = 0, evenErrorInd = 0, n = nums.length;
        boolean odd = false, even = false;

        while (oddErrorInd != n && evenErrorInd != n) {
            if (oddErrorInd % 2 == 1 && nums[oddErrorInd] % 2 == 0) {
                odd = true;
            } else {
                oddErrorInd++;
            }

            if (evenErrorInd % 2 == 0 && nums[evenErrorInd] % 2 == 1) {
                even = true;
            } else {
                evenErrorInd++;
            }

            if (odd && even) {
                int tmp = nums[oddErrorInd];
                nums[oddErrorInd] = nums[evenErrorInd];
                nums[evenErrorInd] = tmp;
                odd = false;
                even = false;
                oddErrorInd++;
                evenErrorInd++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {

        int[]nums = {4,2,5,7};

        Solution sol = new Solution();
        int[] ret = sol.sortArrayByParityII(nums);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
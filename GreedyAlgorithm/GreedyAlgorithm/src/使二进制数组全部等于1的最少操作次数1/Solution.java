package 使二进制数组全部等于1的最少操作次数1;

class Solution {
    public int minOperations(int[] nums) {

        int cnt = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                cnt++;
                for (int j = 0; j < 3; j++) {
                    nums[i + j] = nums[i + j] == 1 ? 0 : 1;
                }
            }
        }

        for (int i = nums.length - 2; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        int[]nums = {0,1,1,1,0,0};

        Solution sol = new Solution();
        int ret = sol.minOperations(nums);

        System.out.println(ret);
    }
}


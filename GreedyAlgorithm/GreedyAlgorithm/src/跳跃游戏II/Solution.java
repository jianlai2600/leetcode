package 跳跃游戏II;

class Solution {
    public int jump(int[] nums) {

        int cnt = 0, curRange = 0, nextRange = 0, n = nums.length;

        if (n == 1) {
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            nextRange = Math.max(nextRange, i + nums[i]);
            if (i == curRange) {
                cnt++;
                curRange = nextRange;
                if (nextRange >= n - 1) {
                    break;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 1};

        Solution sol = new Solution();
        int ret = sol.jump(nums);

        System.out.println(ret);
    }
}


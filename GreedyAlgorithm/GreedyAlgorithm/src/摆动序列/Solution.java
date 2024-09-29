package 摆动序列;

class Solution {

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        // normal process
        int ret = 1;
        int preDiff = 0, curDiff = 0;

        for (int i = 0; i < n - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                ret++;
                preDiff = curDiff;
            }
        }

        return ret;
    }

    public int wiggleMaxLength2(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        int ret = 0, now, last = -2;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            now = nums[i] > nums[i - 1] ? 1 : -1;
            if (now != last) {
                ret++;
            }
            last = now;
        }
        return ++ret;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2, 3, 4};

        Solution sol = new Solution();
        int ret = sol.wiggleMaxLength2(nums);

        System.out.println(ret);
    }
}


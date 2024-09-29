package 让所有学生保持开心的分组方法数;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {

        nums.sort(Comparator.naturalOrder());
        int ret = 0, n = nums.size();

        for (int selectNum = 0; selectNum <= n; selectNum++) {
            if (selectNum > 0 && nums.get(selectNum - 1) >= selectNum) {
                continue;
            }
            if (selectNum < n && nums.get(selectNum) <= selectNum) {
                continue;
            }
            ret++;
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]tmp = {6,0,3,3,6,7,2,7};
        List<Integer>nums = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            nums.add(tmp[i]);
        }

        Solution sol = new Solution();
        int ret = sol.countWays(nums);

        System.out.println(ret);
    }
}
package 下一个更大元素3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void swap(int[]nums, int left, int right) {

        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public int nextGreaterElement(int n) {

        String s = String.valueOf(n);
        int len = s.length();
        int[]nums = new int[len];

        int index = len - 1;
        while (n > 0) {
            nums[index--] = n % 10;
            n /= 10;
        }

        int pos = 0;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i;
                break;
            }
        }

        if (pos == 0) {
            return -1;
        }
        int little = pos - 1;
        int big = 0;
        for (int i = pos; i < len; i++) {
            if (nums[i] > nums[little]) {
                big = i;
            }
        }
        swap(nums, little, big);

        int left = pos, right = len - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }

        long res = 0;
        for (int i = 0; i < len; i++) {
            res *= 10;
            res += nums[i];
        }
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)res;
    }
    public static void main(String[] args) {

        int n = 12;

        Solution sol = new Solution();
        int ret = sol.nextGreaterElement(n);

        System.out.println(ret);
    }
}
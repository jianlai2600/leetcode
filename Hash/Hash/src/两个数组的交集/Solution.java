package 两个数组的交集;


import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer>res = new HashSet<>();

        Set<Integer>set = new HashSet<>();
        for (Integer item : nums1) {
            set.add(item);
        }

        for (Integer item : nums2) {
            if (set.contains(item)) {
                res.add(item);
            }
        }

        int[]ret = new int[res.size()];
        int ind = 0;
        for (Integer item : res) {
            ret[ind++] = item;
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};

        Solution sol = new Solution();
        int[] ret = sol.intersection(num1, num2);

        System.out.println(ret[0]);
    }
}




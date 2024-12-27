package 移除后集合的最多元素数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        int all = set1.size();

        for (int num : nums2) {
            if (set2.contains(num)) {
                continue;
            }
            set2.add(num);
            if (!set1.contains(num)) {
                all++;
            }
        }

        int n = nums1.length;
        int n1 = set1.size();
        int n2 = set2.size();

        int c1 = Math.min(n / 2, n1);
        int c2 = Math.min(n / 2, n2);
        return Math.min(all, c1 + c2);
    }
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4,5,6}, nums2 = {2,3,2,3,2,3};

        Solution sol = new Solution();
        int ret = sol.maximumSetSize(nums1, nums2);

        System.out.println(ret);
    }
}




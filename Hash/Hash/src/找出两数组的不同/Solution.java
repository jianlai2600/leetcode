package 找出两数组的不同;

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Integer integer : set1) {
            if (!set2.contains(integer)) {
                list1.add(integer);
            }
        }
        for (Integer integer : set2) {
            if (!set1.contains(integer)) {
                list2.add(integer);
            }
        }
        ret.add(list1);
        ret.add(list2);
        return ret;
    }
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        Solution sol = new Solution();
        List<List<Integer>>ret = sol.findDifference(nums1, nums2);

        for (List<Integer> list : ret) {
            System.out.print(list + " ");
        }
    }
}




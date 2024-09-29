package 最大二叉树;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TransferQueue;

class Solution {
    public TreeNode makeNode(int[]nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int index = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = makeNode(nums, left, index - 1);
        node.right = makeNode(nums, index + 1, right);

        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return makeNode(nums, 0, nums.length - 1);
    }

    public static void main(String[] args){

        int[] nums = {3,2,1,6,0,5};

        Solution sol = new Solution();
        TreeNode ret = sol.constructMaximumBinaryTree(nums);

        System.out.println(ret.left.right.val);
    }
}


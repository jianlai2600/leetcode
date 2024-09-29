package 将有序数组转换为二叉搜索树;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    //Method 1
    public static TreeNode helper(int[] nums, int l, int r){
        if (l > r)return null;

        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    //Method 2
    public static TreeNode helper2(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper2(nums, left,  mid - 1);
        node.right = helper2(nums, mid + 1, right);

        return node;
    }
    public static TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length - 1);
    }
    // Method 3
    public TreeNode makeTree(int[]nums, int left, int right) {

        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = makeTree(nums, left, mid - 1);
        node.right = makeTree(nums, mid + 1, right);

        return node;
    }
    public TreeNode sortedArrayToBST3(int[] nums) {

        return makeTree(nums, 0, nums.length - 1);
    }
    public static void main(String[] args){

        int[] nums = {-10, -3, 1, 5, 9};

        Solution sol = new Solution();
        TreeNode ret = sol.sortedArrayToBST3(nums);

        System.out.println(ret.val);
    }
}


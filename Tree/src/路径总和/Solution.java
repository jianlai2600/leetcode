package 路径总和;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean backTracking(TreeNode node, int sum) {

        if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return false;
        }

        if (node.left != null) {
            sum -= node.left.val;
            if (backTracking(node.left, sum)) {
                return true;
            }
            sum += node.left.val;
        }
        if (node.right != null) {
            sum -= node.right.val;
            if (backTracking(node.right, sum)) {
                return true;
            }
            sum += node.right.val;
        }
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        return backTracking(root, targetSum - root.val);
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        t1.left = t2;

        Solution sol = new Solution();
        boolean ret = sol.hasPathSum(t1, 1);

        System.out.println(ret);
    }
}


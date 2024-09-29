package 二叉树的最小深度;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);

        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-1);

        t1.left = t2;
        t1.right = t3;

        t3.left = t6;
        t3.right = t7;
        t6.left = t8;

        Solution sol = new Solution();
        int ret = sol.minDepth(t1);

        System.out.println(ret);
    }
}


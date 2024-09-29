package 平衡二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = height2(node.left);
        int rh = height2(node.right);

        if (lh == -1) {
            return -1;
        }
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
    public boolean isBalanced2(TreeNode root) {

        return height2(root) == -1 ? false : true;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t5.right = t6;

        Solution sol = new Solution();
        boolean ret = sol.isBalanced(t1);

        System.out.println(ret);
    }
}


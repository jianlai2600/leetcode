package 完全二叉树的节点个数;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int ret;
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        ret++;
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public int countNodes(TreeNode root) {

        ret = 0;
        preOrderTraversal(root);
        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Solution sol = new Solution();
        int ret = sol.countNodes(t1);

        System.out.println(ret);
    }
}


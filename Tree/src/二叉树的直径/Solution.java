package 二叉树的直径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int ret;
    public int traversal(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = traversal(node.left);
        int right = traversal(node.right);
        ret = Math.max(ret, left + right + 1);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {

        ret = 0;
        traversal(root);
        return ret - 1;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        Solution sol = new Solution();
        int ret = sol.diameterOfBinaryTree(t1);

        System.out.println(ret);
    }
}


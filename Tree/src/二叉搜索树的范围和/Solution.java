package 二叉搜索树的范围和;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int ret;
    public void midTraversal(TreeNode node, int low, int high) {

        if (node == null) {
            return;
        }
        midTraversal(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            ret += node.val;
        }
        midTraversal(node.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {

        ret = 0;
        midTraversal(root, low, high);
        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(18);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        Solution sol = new Solution();
        int ret = sol.rangeSumBST(t1, 7, 15);

        System.out.println(ret);
    }
}


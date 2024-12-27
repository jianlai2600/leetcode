package 二叉树剪枝;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode traverseTree(TreeNode node) {

        if (node == null) {
            return null;
        }

        node.left = traverseTree(node.left);
        node.right = traverseTree(node.right);
        if (node.val == 0 && node.left == null && node.right == null) {
            return null;
        }
        return node;
    }
    public TreeNode pruneTree(TreeNode root) {

        TreeNode res = traverseTree(root);
        return res;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(1);

        t1.right = t2;
        t2.left = t3;
        t2.right = t4;

        Solution sol = new Solution();
        TreeNode root = sol.pruneTree(t1);

        System.out.println(root.val);
    }
}


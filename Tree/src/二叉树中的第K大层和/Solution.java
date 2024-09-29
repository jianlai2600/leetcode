package 二叉树中的第K大层和;

import javax.lang.model.util.Elements;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public boolean isSame(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return subRoot == null;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(5);

        TreeNode s1 = new TreeNode(2);
        TreeNode s2 = new TreeNode(9);
        TreeNode s3 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        s1.left = s2;
        s1.right = s3;

        Solution sol = new Solution();
        boolean ret = sol.isSubtree(t1, s1);

        System.out.println(ret);
    }
}


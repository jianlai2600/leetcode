package 修剪二叉搜索树;

import java.util.ArrayList;

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return root;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        } else {
            if (root.left != null && root.right != null) {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.left = root.left;
                return trimBST(root.right, low, high);
            } else if (root.left != null) {
                return trimBST(root.left, low, high);
            } else if (root.right != null) {
                return trimBST(root.right, low, high);
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        Solution sol = new Solution();
        TreeNode ret = sol.trimBST(t1, 1, 2);

        System.out.println(ret.val);
    }
}


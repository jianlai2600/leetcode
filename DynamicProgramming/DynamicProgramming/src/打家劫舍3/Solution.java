package 打家劫舍3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] helper(TreeNode node) {
        // 0: no steal
        // 1: steal
        if (node == null) {
            return new int[2];
        }
        int[]ret = new int[2];

        int[]left = helper(node.left);
        int[]right = helper(node.right);

        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = left[0] + right[0] + node.val;

        return ret;
    }
    public int rob(TreeNode root) {

        int[]ret = helper(root);
        return Math.max(ret[0], ret[1]);
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;

        Solution sol = new Solution();
        int ret = sol.rob(t1);

        System.out.println(ret);
    }
}



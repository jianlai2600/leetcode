package 二叉树中第二小的节点;

import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        helper(node.left);
        helper(node.right);
    }
    public int findSecondMinimumValue(TreeNode root) {

        helper(root);

        if (set.size() < 2) {
            return -1;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (Integer integer : set) {
            if (integer < first) {
                second = first;
                first = integer;
            } else if (integer <= second) {
                second = integer;
            }
        }
        return second;
    }
    public void helper2(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        if (node.val != value) {
            if (ans == -1) {
                ans = node.val;
            } else {
                ans = Math.min(ans, node.val);
            }
            return;
        }
        helper2(node.left, value);
        helper2(node.right, value);
    }
    int ans = -1;
    public int findSecondMinimumValue2(TreeNode root) {

        helper2(root, root.val);
        return ans;
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5);

        t1.right = t2;
        t2.left = t3;
        t3.left = t4;
        t3.right = t5;

        Solution sol = new Solution();
        int res = sol.findSecondMinimumValue2(t1);

        System.out.println(res);
    }
}


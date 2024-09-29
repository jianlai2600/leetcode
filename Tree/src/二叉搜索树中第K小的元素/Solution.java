package 二叉搜索树中第K小的元素;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {

    int cnt;
    int ret;
    public void helper(TreeNode root)
    {
        if (root == null)return;

        helper(root.left);
        cnt--;
        if (cnt == 0)
        {
            ret = root.val;
            return;
        }
        helper(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        helper(root);

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        int k = 3;

        Solution sol = new Solution();
        Integer ret = sol.kthSmallest(t1, k);

        System.out.println(ret);
    }
}


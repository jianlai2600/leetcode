package 从前序与中序遍历序列构造二叉树;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

class Solution {

    private Map<Integer, Integer>indexMap;

    public void preorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.val + "->");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public TreeNode recursion(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {

        if (pl > pr) {
            return null;
        }

        int val = preorder[pl];
        int ind = indexMap.get(val);

        TreeNode root = new TreeNode(val);
        int l = ind - il;
        root.left = recursion(preorder, inorder, pl + 1, pl + l, il, ind - 1);
        root.right = recursion(preorder, inorder, pl + l + 1, pr, ind + 1, ir);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = inorder.length;

        indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
        {
            indexMap.put(inorder[i], i);
        }

        return recursion(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args){

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Solution sol = new Solution();
        TreeNode ret = sol.buildTree(preorder, inorder);

        sol.preorderTraversal(ret);

    }
}


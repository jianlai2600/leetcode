package 从中序与后序遍历序列构造二叉树;

import java.util.Arrays;

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = postorder.length;
        if (n == 0) {
            return null;
        }
        int val = postorder[n - 1];
        TreeNode node = new TreeNode(val);

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        int leftLen = index;
        int rightLen = n - leftLen - 1;

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, leftLen),
                Arrays.copyOfRange(postorder, 0, leftLen));
        node.right = buildTree(Arrays.copyOfRange(inorder, leftLen + 1, leftLen + 1 + rightLen),
                Arrays.copyOfRange(postorder, leftLen, leftLen + rightLen));
        return node;
    }

    public static void main(String[] args){

        int[] inorder = {2, 1};
        int[] postorder = {2, 1};

        Solution sol = new Solution();
        TreeNode ret = sol.buildTree(inorder, postorder);

        System.out.println(ret.val);
    }
}


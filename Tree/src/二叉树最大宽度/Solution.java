package 二叉树最大宽度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int maxWidth;
    public void levelOrderTraversal(TreeNode node) {

        Queue<TreeNode>queue = new LinkedList<>();
        Queue<Integer>index = new LinkedList<>();
        index.add(1);
        queue.add(node);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int minNum = -1, maxNum = -1;

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                int ind = index.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    index.add(ind * 2);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    index.add(ind * 2 + 1);
                }
                if (i == 0) {
                    minNum = ind;
                }
                if (i == size - 1) {
                    maxNum = ind;
                }
            }
            maxWidth = Math.max(maxWidth, maxNum - minNum + 1);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        maxWidth = 0;
        levelOrderTraversal(root);

        return maxWidth;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.left = t6;
        t5.left = t7;

        Solution sol = new Solution();
        int ret = sol.widthOfBinaryTree(t1);

        System.out.println(ret);
    }
}


package 奇偶树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {

        if (root.val % 2 == 0) {
            return false;
        }
        boolean isOdd = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int preVal = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (preVal == -1) {
                    preVal = node.val;
                    if ((preVal % 2 == 0 && isOdd) || (preVal % 2 == 1 && !isOdd)) {
                        return false;
                    }
                } else {

                    int curVal = node.val;
                    if ((curVal % 2 == 0 && isOdd) || (curVal % 2 == 1 && !isOdd)) {
                        return false;
                    }
                    if ((curVal >= preVal && !isOdd) || (curVal <= preVal && isOdd)) {
                        return false;
                    }
                    preVal = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            isOdd = !isOdd;
        }
        return true;
    }

    public static void main(String[] args){

        // Level 3
        TreeNode node12 = new TreeNode(12);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);

        // Level 2
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        // Connect Level 2 to Level 3
        node3.left = node12;
        node3.right = node8;
        node7.left = node6;
        node9.right = node2;

        // Level 1
        TreeNode node10 = new TreeNode(10);
        TreeNode node4 = new TreeNode(4);

        // Connect Level 1 to Level 2
        node10.left = node3;
        node4.left = node7;
        node4.right = node9;

        // Level 0 (Root)
        TreeNode root = new TreeNode(1);

        // Connect Level 0 to Level 1
        root.left = node10;
        root.right = node4;

        Solution sol = new Solution();
        boolean ret = sol.isEvenOddTree(root);

        System.out.println(ret);
    }
}


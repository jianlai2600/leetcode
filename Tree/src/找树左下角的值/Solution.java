package 找树左下角的值;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 层序遍历
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);

        int ret = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == 0) {
                    ret = node.val;
                }
            }
        }
        return ret;
    }

    // 递归遍历
    int maxDepth = Integer.MIN_VALUE;
    int ret = 0;
    public void traversal(TreeNode node, int depth) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && depth > maxDepth) {
            maxDepth = depth;
            ret = node.val;
            return;
        }
        if (node.left != null) {
            traversal(node.left, depth + 1);
        }
        if (node.right != null) {
            traversal(node.right, depth + 1);
        }
    }
    public int findBottomLeftValue2(TreeNode root) {

        traversal(root, 0);
        return ret;
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
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;

        Solution sol = new Solution();
        int ret = sol.findBottomLeftValue2(t1);

        System.out.println(ret);
    }
}


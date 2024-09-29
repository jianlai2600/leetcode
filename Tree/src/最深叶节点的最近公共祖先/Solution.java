package 最深叶节点的最近公共祖先;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    int curMax = Integer.MIN_VALUE;
    int ret = 1;
    public void layerTraversal(TreeNode node) {

        int layer = 1;

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            if (sum > curMax) {
                curMax = sum;
                ret = layer;
            }
            layer++;
        }
    }
    public int maxLevelSum(TreeNode root) {

        layerTraversal(root);

        return ret;
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(-8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        Solution sol = new Solution();
        int ret = sol.maxLevelSum(t1);

        System.out.println(ret);
    }
}
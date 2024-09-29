package 好叶子节点对的数量;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int ans;
    public int[] dfs(TreeNode node, int distance) {

        if (node == null) {
            return new int[0];
        }
        if (node.left == null && node.right == null) {
            return new int[1];
        }
        var left = dfs(node.left, distance);
        var right = dfs(node.right, distance);

        List<Integer>ret = new LinkedList<>();

        for (int i = 0; i < left.length; i++) {
            left[i]++;
            if (left[i] <= distance) {
                ret.add(left[i]);
            }
        }
        for (int i = 0; i < right.length; i++) {
            right[i]++;
            if (right[i] <= distance) {
                ret.add(right[i]);
            }
        }
        for (var l : left) {
            for (var r : right) {
                if (l + r <= distance) {
                    ans++;
                }
            }
        }
        int[]retArr = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }
    public int countPairs(TreeNode root, int distance) {

        ans = 0;
        dfs(root, distance);
        return ans;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        Solution sol = new Solution();
        int ret = sol.countPairs(t1, 3);

        System.out.println(ret);
    }
}


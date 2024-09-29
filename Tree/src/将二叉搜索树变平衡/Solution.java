package 将二叉搜索树变平衡;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void inorderTraversal(TreeNode root, List l) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    public static TreeNode helper(List<Integer> nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = helper(nums, left,  mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer>value = new ArrayList<>();
        inorderTraversal(root, value);

        return helper(value, 0, value.size() - 1);
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.right = t2;
        t2.right = t3;
        t3.right = t4;

        Solution sol = new Solution();
        TreeNode ret = sol.balanceBST(t1);

        System.out.println(ret.val);
    }
}


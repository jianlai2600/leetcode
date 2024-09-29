package 叶子相似的树;

import java.util.*;

class Solution {
    List<Integer>list = new ArrayList<>();
    public void backTraversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        if (node.left != null) {
            backTraversal(node.left);
        }
        if (node.right != null) {
            backTraversal(node.right);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        backTraversal(root1);
        List<Integer>tmp = new ArrayList<>(list);

        list = new ArrayList<>();
        backTraversal(root2);

        if (list.size() != tmp.size()) {
            return false;
        }
        int n = tmp.size();
        for (int i = 0; i < n; i++) {
            if (!Objects.equals(list.get(i), tmp.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(200);

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(200);

        t1.left = t2;
        t1.right = t3;

        r1.left = r2;
        r1.right = r3;

        Solution sol = new Solution();
        boolean res = sol.leafSimilar(t1, r1);

        System.out.println(res);
    }
}


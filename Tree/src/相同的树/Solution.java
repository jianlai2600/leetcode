package 相同的树;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void inorderTraversal(TreeNode root, List l) {
        if (root == null) {
            l.add(0.13);
            return;
        }
        l.add(root.val);
        inorderTraversal(root.left, l);
        inorderTraversal(root.right, l);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        List<Integer>l1 = new ArrayList<>();
        List<Integer>l2 = new ArrayList<>();

        inorderTraversal(p, l1);
        inorderTraversal(q, l2);

        System.out.println(l1);
        System.out.println(l2);

        return l1.equals(l2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);

        t1.left = t2;

        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(0);

        s1.right = s2;

        Solution sol = new Solution();
        boolean ret = sol.isSameTree(t1, s1);

        System.out.println(ret);
    }
}


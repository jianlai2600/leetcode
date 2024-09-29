package 递归遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public void preorderTraversal(TreeNode root, List l) {

        if (root == null) {
            return;
        }

        l.add(root.val);
        preorderTraversal(root.left, l);
        preorderTraversal(root.right, l);
    }

    public void inorderTraversal(TreeNode root, List l) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    public void postorderTraversal(TreeNode root, List l) {

        if (root == null) {
            return;
        }

        postorderTraversal(root.left, l);
        postorderTraversal(root.right, l);
        l.add(root.val);
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        Solution sol = new Solution();

        List<Integer> l1 = new ArrayList<>();
        sol.preorderTraversal(t1, l1);
        for (Integer item : l1) {
            System.out.print(item + " ");
        }
        System.out.println();

        List<Integer> l2 = new ArrayList<>();
        sol.inorderTraversal(t1, l2);
        for (Integer item : l2) {
            System.out.print(item + " ");
        }
        System.out.println();

        List<Integer> l3 = new ArrayList<>();
        sol.postorderTraversal(t1, l3);
        for (Integer item : l3) {
            System.out.print(item + " ");
        }
        System.out.println();

    }
}


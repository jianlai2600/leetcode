package 删点成林;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<TreeNode>res = new ArrayList<>();
    public TreeNode traverse(TreeNode root, int val, int index) {

        if (root.val == val) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            return null;
        }
        if (root.left != null) {
            root.left = traverse(root.left, val, index);
        }
        if (root.right != null) {
            root.right = traverse(root.right, val, index);
        }
        return root;
    }
    public void helper(int val) {

        for (int i = 0; i < res.size(); i++) {
            int size = res.size();
            TreeNode retNode = traverse(res.get(i), val, i);
            if (retNode == null) {
                res.remove(i);
            }
            if (size != res.size()) {
                break;
            }
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        res.add(root);
        for (Integer value : to_delete) {
            helper(value);
        }

        return res;
    }
    // Method 2
    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {

        Set<Integer> set = new HashSet<>();
        for (Integer value : to_delete) {
            set.add(value);
        }

        traverse2(root, set, true);
        return res;
    }
    public TreeNode traverse2(TreeNode root, Set<Integer>set, boolean isRoot) {

        if (root == null) {
            return null;
        }
        boolean toDelete = false;
        if (set.contains(root.val)) {
            toDelete = true;
        }

        if (isRoot && !toDelete) {
            res.add(root);
        }

        root.left = traverse2(root.left, set, toDelete);
        root.right = traverse2(root.right, set, toDelete);

        return toDelete ? null : root;
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
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        int[]to_delete = {3,5};

        Solution sol = new Solution();
        List<TreeNode>ret = sol.delNodes(t1, to_delete);

        for (TreeNode node : ret) {
            System.out.println(node.val);
        }
    }
}


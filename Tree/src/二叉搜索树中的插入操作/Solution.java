package 二叉搜索树中的插入操作;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
            return root;
        } else {
            root.left = insertIntoBST(root.left, val);
            return root;
        }
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        Solution sol = new Solution();
        TreeNode ret = sol.insertIntoBST(t1, 7);

        System.out.println(ret.val);
    }
}


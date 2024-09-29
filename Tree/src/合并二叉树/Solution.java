package 合并二叉树;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);

        TreeNode j1 = new TreeNode(2);
        TreeNode j2 = new TreeNode(1);
        TreeNode j3 = new TreeNode(3);
        TreeNode j4 = new TreeNode(4);
        TreeNode j5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        j1.left = j2;
        j1.right = j3;
        j2.right = j4;
        j3.right = j5;

        Solution sol = new Solution();
        TreeNode ret = sol.mergeTrees(t1, j1);

        System.out.println(ret.val);
    }
}


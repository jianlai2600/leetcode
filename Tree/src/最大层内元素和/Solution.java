package 最大层内元素和;

class Solution {
    public boolean isValid(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                isValid(left.left, right.right) && isValid(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {

        return isValid(root.left, root.right);
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Solution sol = new Solution();
        boolean ret = sol.isSymmetric(t1);

        System.out.println(ret);
    }
}


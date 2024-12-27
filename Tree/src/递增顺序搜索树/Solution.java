package 递增顺序搜索树;

class Solution {
    public TreeNode[] helper(TreeNode node) {

        TreeNode[]res = new TreeNode[2];
        if (node == null) {
            return res;
        }

        TreeNode[]leftRes = helper(node.left);
        TreeNode[]rightRes = helper(node.right);

        if (leftRes[1] != null) {
            leftRes[1].right = node;
        }

        node.left = null;
        node.right = rightRes[0];

        res[0] = leftRes[1] == null ? node : leftRes[0];
        res[1] = rightRes[0] == null ? node : rightRes[1];

        return res;
    }
    public TreeNode increasingBST(TreeNode root) {

        TreeNode[]res = helper(root);
        return res[0];
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        Solution sol = new Solution();
        TreeNode ret = sol.increasingBST(t1);

        System.out.println(ret);
    }
}


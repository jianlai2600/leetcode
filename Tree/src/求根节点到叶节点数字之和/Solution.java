package 求根节点到叶节点数字之和;

class Solution {
    int ret = 0;
    int singleAns = 0;
    public void traversal(TreeNode node) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            ret += singleAns * 10 + node.val;
            return;
        }
        singleAns = singleAns * 10 + node.val;
        int tmp = singleAns;
        traversal(node.left);
        singleAns = tmp;
        traversal(node.right);
    }
    public int sumNumbers(TreeNode root) {
        traversal(root);
        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        Solution sol = new Solution();
        int ret = sol.sumNumbers(t1);

        System.out.println(ret);
    }
}


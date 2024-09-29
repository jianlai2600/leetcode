package 二叉树的最近公共祖先;

class Solution {
    private TreeNode ans;

    public Solution()
    {
        ans = null;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
        {
            ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // Method 2
    public boolean haveNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root.equals(p) || root.equals(q)) {
            return true;
        }
        return haveNode(root.left, p, q) || haveNode(root.right, p, q);
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }
        if (root.equals(q) || root.equals(p)) {
            if (haveNode(root.left, p, q) || haveNode(root.right, p, q)) {
                return root;
            }
        }
        if (haveNode(root.left, p, q) && haveNode(root.right, p, q)) {
            return root;
        }

        if (!haveNode(root.left, p, q)) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return lowestCommonAncestor2(root.left, p, q);
        }
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t3.left = t7;
        t5.left = t8;
        t5.right = t9;

        Solution sol = new Solution();
        TreeNode ret = sol.lowestCommonAncestor2(t1, t2, t9);

        System.out.println(ret.val);
    }
}


package 输出二叉树;

import java.util.*;

class Solution {
    public List<List<String>> printTree(TreeNode root) {

        // get height
        int height = 0;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            height++;
        }
        //
        height--;
        int m = height + 1, n = (int) Math.pow(2, m) - 1;
        List<List<String>>res = new ArrayList<>();
        //
        List<String>row = new ArrayList<>(Collections.nCopies(n, ""));
        row.set((n - 1) / 2, String.valueOf(root.val));
        res.add(row);

        Map<TreeNode, Integer>map = new HashMap<>();
        map.put(root, (n - 1) / 2);

        queue.clear();
        queue.add(root);

        int r = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            row = new ArrayList<>(Collections.nCopies(n, ""));
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                int index = map.get(tmp);

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    int tmpIndex = index - (int) Math.pow(2, height - r - 1);
                    row.set(tmpIndex, String.valueOf(tmp.left.val));
                    map.put(tmp.left, tmpIndex);
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                    int tmpIndex = index + (int) Math.pow(2, height - r - 1);
                    row.set(tmpIndex, String.valueOf(tmp.right.val));
                    map.put(tmp.right, tmpIndex);
                }
            }
            res.add(row);
            r++;
        }
        //
        res.removeLast();
        return res;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
//        t1.right = t3;
//        t2.right = t4;

        Solution sol = new Solution();
        List<List<String>> res = sol.printTree(t1);

        for (List<String>row : res) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


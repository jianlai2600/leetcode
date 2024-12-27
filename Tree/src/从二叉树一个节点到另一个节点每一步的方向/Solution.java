package 从二叉树一个节点到另一个节点每一步的方向;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    String s, t;
    List<Integer>sl;
    List<Integer>tl;
    public void traverse(TreeNode node, int startValue, int destValue, StringBuilder sb, List<Integer> list) {

        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.val == startValue) {
            s = sb.toString();
            sl = new ArrayList<>(list);
        }
        if (node.val == destValue) {
            t = sb.toString();
            tl = new ArrayList<>(list);
        }
        sb.append('L');
        traverse(node.left, startValue, destValue, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        traverse(node.right, startValue, destValue, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        list.removeLast();
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {

        List<Integer>list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        traverse(root, startValue, destValue, sb, list);

        Set<Integer> set = new HashSet<>();
        int lastSame = 0;
        for (Integer integer : sl) {
            set.add(integer);
        }
        for (Integer integer : tl) {
            if (!set.contains(integer)) {
                break;
            } else {
                lastSame = integer;
            }
        }

        int sIndex = sl.indexOf(lastSame);
        int tIndex = tl.indexOf(lastSame);

        int sLen = sIndex + 1;
        int tLen = tIndex + 1;

        s = s.substring(sIndex);
        t = t.substring(tIndex);

        if (!s.isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                sb.append('U');
            }
        }
        for (int i = 0; i < t.length(); i++) {
            sb.append(t.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;

        Solution sol = new Solution();
        String ret = sol.getDirections(t1, 3, 6);

        System.out.println(ret);
    }
}


package 搜索推荐系统;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class Trie {
        Trie[]children;
        boolean isWord;
        Trie() {
            children = new Trie[26];
            isWord = false;
        }
        private void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
    public List<String> find(Trie node, StringBuilder sb) {
        List<String> result = new ArrayList<>();

        // 辅助方法：递归遍历 Trie 子树
        dfs(node, sb, result);

        return result;
    }

    // 深度优先搜索 (DFS)
    private void dfs(Trie node, StringBuilder sb, List<String> result) {
        // 如果找到 3 个单词，停止递归
        if (result.size() >= 3) {
            return;
        }
        if (node == null) {
            return;
        }
        // 如果当前节点是一个单词，添加到结果列表
        if (node.isWord) {
            result.add(sb.toString());
        }

        // 遍历子节点
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sb.append((char) (i + 'a')); // 添加当前字符
                dfs(node.children[i], sb, result); // 递归
                sb.deleteCharAt(sb.length() - 1); // 回溯
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie mainNode = new Trie();

        for (String s : products) {
            mainNode.insert(s);
        }

        List<List<String>>res = new ArrayList<>();

        Trie curNode = mainNode;
        StringBuilder sb = new StringBuilder();

        for (Character c : searchWord.toCharArray()) {

            sb.append(c);
            if (curNode.children[c - 'a'] == null) {
                break;
            }
            curNode = curNode.children[c - 'a'];

            List<String>tmp = find(curNode, sb);

            res.add(new ArrayList<>(tmp));
        }
        while (res.size() != searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;
    }

    public static void main(String[] args) {

        String[] products = {"mobile"};
        String searchWord = "mo";

        Solution sol = new Solution();
        List<List<String>>res = sol.suggestedProducts(products, searchWord);

        for (List<String>row : res) {
            for (String word : row) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}



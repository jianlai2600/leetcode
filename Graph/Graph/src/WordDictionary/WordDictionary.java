package WordDictionary;

class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    public Trie[] getChildren() {
        return children;
    }
    public boolean getEnd() {
        return isEnd;
    }
    public void insert(String s) {

        Trie node = this;
        for (Character c : s.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}
class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    private boolean dfs(Trie node, String s, int start) {

        if (start == s.length()) {
            return node.getEnd();
        }
        char c = s.charAt(start);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.getChildren()[j] != null) {
                    if (dfs(node.getChildren()[j], s, start + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int index = c - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            } else {
                return dfs(node.getChildren()[index], s, start + 1);
            }
        }
    }
    public boolean search(String word) {

        return dfs(root, word, 0);
    }
}

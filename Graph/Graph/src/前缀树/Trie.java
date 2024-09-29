package 前缀树;

class Trie {

    private boolean isEnd;
    private Trie []children;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null)
            {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null)return false;
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null)return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}




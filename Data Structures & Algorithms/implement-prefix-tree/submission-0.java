class PrefixTree {

    private final TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        var charArray = word.toCharArray();
        var cur = root;
        for(char c : charArray) {
            cur.childrens.putIfAbsent(c, new TrieNode());
            cur = cur.childrens.get(c);
        }
        cur.isEndofWord = true;
    }

    public boolean search(String word) {
        var charArray = word.toCharArray();
        var cur = root;
        for(char c : charArray) {
            if(cur.childrens.containsKey(c)) {
                cur = cur.childrens.get(c);
            } else {
                return false;
            }
        }
        return cur.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        var charArray = prefix.toCharArray();
        var cur = root;
        for(char c : charArray) {
            if(cur.childrens.containsKey(c)) {
                cur = cur.childrens.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    boolean isEndofWord;
    HashMap<Character, TrieNode> childrens;
    TrieNode() {
        isEndofWord = false;
        childrens = new HashMap<>();
    }
}



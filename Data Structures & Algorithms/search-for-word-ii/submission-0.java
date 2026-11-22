class Solution {
    private final Trie trie = new Trie();
    private Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(var word : words) {
            trie.insert(word);
        }
        int n = board.length;
        int m = board[0].length;
        TrieNode root = trie.root;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dfs(i,j, vis, board, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int i, int j, boolean[][] vis, char[][] board, TrieNode cur, String word) {
        int n = board.length;
        int m = board[0].length;
        if(i >=n || i<0 || j >=m || j<0 || vis[i][j] || !cur.childrens.containsKey(board[i][j])) {
            return;
        }
        vis[i][j] = true;
        cur = cur.childrens.get(board[i][j]);
        word += board[i][j];
        if(cur.isEndofWord) {
           res.add(word);
        }
        dfs(i+1,j, vis, board, cur, word);
        dfs(i,j+1, vis, board, cur, word);
        dfs(i-1,j, vis, board, cur, word);
        dfs(i,j-1, vis, board, cur, word);
        vis[i][j] = false;
    }

}

class Trie {
    public TrieNode root;
    Trie() {
        this.root = new TrieNode();
    }

    void insert(String word) {
        var charArray = word.toCharArray();
        TrieNode cur = root;
        for(var c  :charArray) {
            cur.childrens.putIfAbsent(c, new TrieNode());
            cur = cur.childrens.get(c);
        }
        cur.isEndofWord = true;
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
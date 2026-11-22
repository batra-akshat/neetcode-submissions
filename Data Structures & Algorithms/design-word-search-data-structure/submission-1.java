class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var characterArray = word.toCharArray();
        TrieNode cur = root;
        for(var c : characterArray) {
            cur.childrens.putIfAbsent(c, new TrieNode());
            cur = cur.childrens.get(c);
        }
        cur.isEndofWord = true;
    }

    public boolean search(String word) {
        List<String> allCombinations = getPossibleStrings(word);
        for( var combination : allCombinations) {
            if(searchHelper(combination)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getPossibleStrings(String word) {
        List<String> result = new ArrayList<>();

        // Find positions of dots
        List<Integer> dotPositions = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                dotPositions.add(i);
            }
        }

        // Convert word to char array for easier manipulation
        char[] chars = word.toCharArray();

        // Generate all combinations
        generateCombinations(chars, dotPositions, 0, result);

        return result;
    }

    private void generateCombinations(char[] chars, List<Integer> dotPositions,
                                      int dotIndex, List<String> result) {
        // Base case: if we've processed all dots, add the current string to result
        if (dotIndex == dotPositions.size()) {
            result.add(new String(chars));
            return;
        }

        // Get the position of the current dot
        int pos = dotPositions.get(dotIndex);

        // Try replacing the dot with each lowercase letter
        for (char c = 'a'; c <= 'z'; c++) {
            chars[pos] = c;
            generateCombinations(chars, dotPositions, dotIndex + 1, result);
        }

        // Restore the dot (backtrack)
        chars[pos] = '.';
    }

    private boolean searchHelper(String word) {
        var characterArray = word.toCharArray();
        TrieNode cur = root;
        for(var c : characterArray) {
            if(cur.childrens.containsKey(c)) {
                cur = cur.childrens.get(c);
            } else {
                return false;
            }
        }
        return cur.isEndofWord;
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
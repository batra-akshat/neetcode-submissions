class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return 0;
        }
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int res = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            res++;
            for(int k=0;k<n;k++) {
                var top = q.poll();
                if(top.equals(endWord)) {
                    return res;
                }
                for (int i = 0; i < top.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (top.charAt(i) == j) continue;
                        String temp = top.substring(0, i) + j + top.substring(i + 1);
                        if (words.contains(temp)) {
                            words.remove(temp);
                            q.add(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

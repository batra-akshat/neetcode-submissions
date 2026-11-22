class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        Map<String, Boolean> mp = new HashMap<>();
        return wordBreakRecursive(s, st, mp);
    }

    private boolean wordBreakRecursive(String s, HashSet<String> st, Map<String, Boolean> mp) {
        if(st.contains(s)) {
            return true;
        }
        if(mp.containsKey(s)) {
            return mp.get(s);
        }
        StringBuilder res = new StringBuilder();
        boolean ans = false;
        for(int i =0 ; i<s.length();i++) {
            res.append(s.charAt(i));
            if(st.contains(res.toString())) {
                if(i + 1 < s.length()) {
                    ans = ans ||  wordBreakRecursive(s.substring(i + 1), st, mp);
                }
            }
        }
        mp.put(s, ans);
        return ans;
    }
}

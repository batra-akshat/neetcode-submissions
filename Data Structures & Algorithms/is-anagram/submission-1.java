class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length != tc.length) {
            return false;
        }
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<sc.length;i++) {
            mp.merge(sc[i], 1, Integer::sum);
        }
        for (char c : tc) {
            int count = mp.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            mp.put(c, count - 1);
        }
        return true;
    }
}

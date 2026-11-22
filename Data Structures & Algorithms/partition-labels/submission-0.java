class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, ArrayDeque<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++) {
            mp.putIfAbsent(s.charAt(i), new ArrayDeque<>());
            mp.get(s.charAt(i)).add(i);
        }
        int prevEnd = -1;
        int windowEnd = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(i > windowEnd) {
                ans.add(windowEnd - prevEnd);
                prevEnd = windowEnd;
            }
            var idxs = mp.get(s.charAt(i));
            var lastIdx = idxs.peekLast();
            if(lastIdx > windowEnd) {
                windowEnd = lastIdx;
            }
        }
        ans.add(windowEnd - prevEnd);
        return ans;
    }
}
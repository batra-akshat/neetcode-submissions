class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        // this works for odd strings
        for(int i = 0;i<n;i++) {
            int l = i;
            int r = i;
            int cnt = 0;
            while(l>=0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                cnt++;
            }
            ans += cnt;
        }
        for(int i =0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                int l = i, r = i + 1;
                int cnt = 0;
                while(l>=0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    cnt++;
                }
                ans += cnt;
            }
        }
        return ans;
    }
}

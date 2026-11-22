class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0;i<n;i++) {
            int l = i;
            int r = i;
            while(l>=0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            String res = s.substring(l+1, r);
            if(res.length() > ans.length()) {
                ans = res;
            }
        }

        for(int i =0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                int l = i, r = i + 1;
                while(l>=0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                String res = s.substring(l + 1, r);
                if(res.length() > ans.length()) {
                    ans = res;
                }
            }
        }
        return ans;
    }
}

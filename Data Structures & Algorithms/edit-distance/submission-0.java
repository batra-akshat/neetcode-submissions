class Solution {
    private Integer[][] dp;
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new Integer[n][m];
        return dfs(0,0,s,t);
    }

    private int dfs(int i, int j, String s, String t) {
        if(j == t.length() && i == s.length()) {
            return 0;
        }
        if(i == s.length()) {
            return t.length() - j;
        }
        if(j == t.length()) {
            return s.length() - i;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int ans;
        if(s.charAt(i) == t.charAt(j)) {
            ans = dfs(i+1,j+1, s, t);
        } else {
            int insert = 1 + dfs(i,j+1, s,t);
            int delete = 1 + dfs(i+1,j,s,t);
            int replace = 1 + dfs(i+1,j+1, s, t);
            ans = replace;
            ans = Math.min(ans, insert);
            ans = Math.min(ans, delete);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

}
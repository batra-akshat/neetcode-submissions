
class Solution {
    private Integer dp[][];
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) {
            return 0;
        }
        dp = new Integer[n][m];
        return dfs(0,0,s,t);
    }

    private int dfs(int i, int j, String s, String t) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int ans = dfs(i+1,j,s,t);
        if(s.charAt(i) == t.charAt(j)) {
            ans += dfs(i+1,j+1, s, t);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

}
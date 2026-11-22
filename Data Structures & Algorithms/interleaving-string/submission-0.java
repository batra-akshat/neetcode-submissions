
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        return dfs(0, 0, 0, s1, s2, s3, dp);
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans = false;
        if (i< s1.length() && s3.charAt(k) == s1.charAt(i)) {
            ans = dfs(i + 1, j, k + 1, s1, s2, s3, dp);
        }
        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            ans = ans || dfs(i, j + 1, k + 1, s1, s2, s3, dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}

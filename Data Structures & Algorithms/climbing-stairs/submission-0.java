class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, 0));
        if(n == 1) {
            return 1;
        }
        dp.set(1,1);
        dp.set(2, 2);
        for(int i=3;i<=n;i++) {
            int val  = dp.get(i-1) + dp.get(i-2);
            dp.set(i, val);
        }
        return dp.get(n);
    }
}

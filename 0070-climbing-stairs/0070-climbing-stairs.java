class Solution {
    private int climb(int n, int[] dp) {
        if(n == -1) return 0;
        else if(n == 0) return 1;
        else if(dp[n] != 0) return dp[n];
        return dp[n] = climb(n-1,dp)+climb(n-2,dp);
    }

    public int climbStairs(int n) {
        return climb(n,new int[n+1]);
    }
}
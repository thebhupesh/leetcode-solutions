class Solution {
    int[] dp = new int[46];
    private int findCount(int n, int curr) {
        if(curr > n) {
            return 0;
        }
        if(dp[n-curr] != -1) {
            return dp[n-curr];
        }
        if(curr == n) {
            return 1;
        }

        dp[n-curr] = findCount(n,curr+1)+findCount(n,curr+2);

        return dp[n-curr];
    }

    public int climbStairs(int n) {
        Arrays.fill(dp,-1);
        return findCount(n,0);
    }
}
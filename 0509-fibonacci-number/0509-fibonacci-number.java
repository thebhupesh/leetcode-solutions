class Solution {
    private int[] dp;

    public Solution() {
        dp = new int[31];
        Arrays.fill(dp,-1);
    }

    public int fib(int n) {
        if(n == 1) return 1;
        else if(n == 0) return 0;
        else if(dp[n] != -1) return dp[n];

        dp[n] = fib(n-1)+fib(n-2);

        return dp[n];
    }
}
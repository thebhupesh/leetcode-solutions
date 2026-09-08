class Solution {
    private int evaluate(int[] coins, int amount, int[] dp) {
        if(dp[amount] != -2) return dp[amount];
        if(amount == 0) return 0;

        int count = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount >= coin) {
                int val = evaluate(coins,amount-coin,dp);
                if(val != -1) count = Math.min(count,val+1);
            }
        }

        dp[amount] = (count == Integer.MAX_VALUE) ? -1 : count;
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {        
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-2);

        return evaluate(coins,amount,dp);
    }
}
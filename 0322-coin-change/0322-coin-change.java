class Solution {
    private int evaluate(int[] coins, int amount, int pos, int[][] dp) {
        if(dp[amount][pos] != -2) return dp[amount][pos];
        if(amount == 0) return 0;

        int count = Integer.MAX_VALUE;
        int invalid = 0;

        for(int i=pos; i>=0; i--) {
            if(amount >= coins[i]) {
                int val = evaluate(coins,amount-coins[i],i,dp);

                if(val != -1) count = Math.min(count,val+1);
                else invalid++;
            } else invalid++;
        }

        dp[amount][pos] = (invalid-1 == pos) ? -1 : count;

        return dp[amount][pos];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[][] dp = new int[amount+1][coins.length];
        
        for(int[] arr : dp) Arrays.fill(arr,-2);

        return evaluate(coins,amount,coins.length-1,dp);
    }
}
class Solution {
    private int[] dp;

    private int findCost(int[] cost, int pos) {
        if(pos >= cost.length) return 0;
        if(dp[pos] != -1) return dp[pos];

        return dp[pos] = cost[pos]+Math.min(findCost(cost,pos+1),findCost(cost,pos+2));        
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp,-1);

        return Math.min(findCost(cost,0),findCost(cost,1));
    }
}
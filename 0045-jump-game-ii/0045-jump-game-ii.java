class Solution {
    private int solve(int[] nums, int[] dp, int pos) {
        if(dp[pos] != 0) return dp[pos];
        else if(nums[pos] == 0) return dp[pos] = -1;

        dp[pos] = Integer.MAX_VALUE;
        
        for(int i=nums[pos]; i>0; i--) {
            int nextPos = pos+i;
            if(nextPos >= nums.length-1) return dp[pos] = 1;

            int val = solve(nums,dp,nextPos);
            if(val != -1) dp[pos] = Math.min(dp[pos],1+val);
        }

        return dp[pos] = (dp[pos] == Integer.MAX_VALUE) ? -1 : dp[pos];
    }

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        
        return solve(nums,new int[nums.length],0);
    }
}
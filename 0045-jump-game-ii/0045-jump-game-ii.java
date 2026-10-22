class Solution {
    private int solve(int[] nums, int[] dp, int pos) {
        if(pos >= nums.length-1) return 0;
        else if(dp[pos] != 0) return dp[pos];
        else if(nums[pos] == 0) return -1;

        dp[pos] = Integer.MAX_VALUE;
        
        for(int i=nums[pos]; i>0; i--) {
            int val = solve(nums,dp,pos+i);
            if(val != -1) dp[pos] = Math.min(dp[pos],1+val);
        }

        return dp[pos] = (dp[pos] == Integer.MAX_VALUE) ? -1 : dp[pos];
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return solve(nums,dp,0);
    }
}
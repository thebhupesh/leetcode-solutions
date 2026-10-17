class Solution {
    private int[] dp;

    private int findAmount(int[] nums, int pos) {
        if(pos >= nums.length) return 0;
        if(dp[pos] != -1) return dp[pos];

        return dp[pos] = Math.max(nums[pos]+findAmount(nums,pos+2), findAmount(nums,pos+1));
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);

        findAmount(nums, 0);

        return dp[0];
    }
}
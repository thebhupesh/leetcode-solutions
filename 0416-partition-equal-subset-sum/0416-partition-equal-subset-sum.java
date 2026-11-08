class Solution {
    private boolean check(int[] nums, int sum, int pos, int[][] dp) {
        if(sum == 0) return true;
        else if(pos == nums.length || sum < 0) return false;
        else if(dp[pos][sum] != -1) return dp[pos][sum] == 1;

        if(check(nums,sum,pos+1,dp) || check(nums,sum-nums[pos],pos+1,dp)) {
            dp[pos][sum] = 1;
            return true;
        }

        dp[pos][sum] = 0;
        return false;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0 || nums.length == 1) return false;

        sum /= 2;
        int[][] dp = new int[nums.length][sum+1];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i],-1);
        
        return check(nums,sum,0,dp);
    }
}
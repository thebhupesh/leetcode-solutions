class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[][] minMax = new int[n][2];

        minMax[0][1] = nums[0];
        minMax[n-1][0] = nums[n-1];

        for(int i=1; i<n; i++) {
            minMax[i][1] = Math.max(nums[i],minMax[i-1][1]);
            minMax[n-1-i][0] = Math.min(nums[n-1-i],minMax[n-i][0]);
        }

        for(int i=0; i<n; i++) {
            if(minMax[i][1]-minMax[i][0] <= k) return i;
        }

        return -1;
    }
}
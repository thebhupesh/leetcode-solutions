class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] scores = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int idx = n;

        for(int i=0; i<n; i++) {
            min = Math.min(min,nums[n-1-i]);
            max = Math.max(max,nums[i]);

            scores[i] += max;
            scores[n-1-i] -= min;

            if(i>=n/2) {
                if(scores[n-1-i] <= k) idx = Math.min(idx,n-1-i);
                else if(scores[i] <= k) idx = Math.min(idx,i);
            }
        }

        return (idx != n) ? idx : -1;
    }
}
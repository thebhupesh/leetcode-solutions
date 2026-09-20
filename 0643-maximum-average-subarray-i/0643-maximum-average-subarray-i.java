class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        double sum = 0;
        int start = 0;
        int end = 0;

        while(end < nums.length) {
            sum += (double) nums[end];
            end++;

            if((end-start) == k) {
                maxSum = Math.max(maxSum,sum);
                sum -= (double) nums[start];
                start++;
            }
        }

        return maxSum/k;
    }
}
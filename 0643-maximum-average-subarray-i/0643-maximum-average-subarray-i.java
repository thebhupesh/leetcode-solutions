class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double sum = 0;
        int start = 0;
        int end = 0;

        while(end < nums.length) {
            sum += (double) nums[end];
            end++;

            if((end-start) == k) {
                res = Math.max(res,sum/k);
                sum -= (double) nums[start];
                start++;
            }
        }

        return res;
    }
}
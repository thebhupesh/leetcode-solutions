class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int curr = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > curr+nums[i]) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }

            result = Integer.max(result, curr);
        }


        return result;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curr = 0;
        int left = 0;
        int right = 0;
        int res = 0;

        while(left < nums.length) {
            if(curr >= target) {
                res = (res == 0) ? (right-left) : Math.min(res,right-left);
                curr -= nums[left];
                left++;
            } else if(right < nums.length) {
                curr += nums[right];
                right++;
            } else break;
        }

        return res;
    }
}
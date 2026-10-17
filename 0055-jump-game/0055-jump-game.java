class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        if(len == 1) return true;
        if(nums[0] == 0) return false;

        int reach = nums[0];

        for(int i=1; i<len; i++) {
            if(i <= reach) reach = Math.max(reach,i+nums[i]);
        }

        return reach >= len-1;
    }
} 
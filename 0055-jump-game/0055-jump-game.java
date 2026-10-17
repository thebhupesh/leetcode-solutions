class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] reach = new boolean[len];

        for(int i=len-1; i>=0; i--) {
            if(i+nums[i] >= len-1) reach[i] = true;
            else {
                for(int j=nums[i]; j>0; j--) {
                    if(reach[i+j]) {
                        reach[i] = true;
                        break;
                    }
                }
            }
        }

        return reach[0];
    }
} 
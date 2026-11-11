class Solution {
    public void moveZeroes(int[] nums) {
        int ptr = 0;
        int len = nums.length;

        for(int i=0; i<len; i++) {
            if(nums[i] != 0) nums[ptr++] = nums[i];
        }

        while(ptr < len) nums[ptr++] = 0;
    }
}
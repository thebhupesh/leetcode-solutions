class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        int count = 1;
        int curr = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] != curr) {
                nums[ptr++] = nums[i];
                curr = nums[i];
                count = 1;
            } else if(count < 2) {
                nums[ptr++] = curr;
                count++;
            }
        }

        return ptr;
    }
}
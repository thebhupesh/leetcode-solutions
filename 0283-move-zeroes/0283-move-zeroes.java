class Solution {
    public void moveZeroes(int[] nums) {
        int ptr1 = 0;
        int ptr2 = 0;
        int len = nums.length;

        while(ptr2 < len) {
            while(ptr1 < len && nums[ptr1] != 0) ptr1++;
            ptr2 = ptr1;

            while(ptr2 < len && nums[ptr2] == 0) ptr2++;

            if(ptr2 < len) {
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = 0;
            }
        }
    }
}
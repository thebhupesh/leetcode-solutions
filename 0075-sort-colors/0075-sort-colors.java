class Solution {
    public void sortColors(int[] nums) {
        int ptr0 = 0;
        int ptr1 = 0;
        int ptr2 = nums.length-1;

        while(ptr1 <= ptr2) {
            if(nums[ptr1] == 0) {
                nums[ptr1] = nums[ptr0];
                nums[ptr0] = 0;
                ptr0++;
                ptr1++;
            } else if(nums[ptr1] == 1) {
                ptr1++;
            } else {
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = 2;
                ptr2--;
            }
        }
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ptr0 = 0;
        int ptr2 = nums.length-1;

        while(ptr0 < len && nums[ptr0] == 0) ptr0++;

        for(int i=ptr0+1; i<len; i++) {
            if(nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr0];
                nums[ptr0] = temp;

                while(ptr0 < len && nums[ptr0] == 0) ptr0++;
            }
        }

        while(ptr2 >= 0 && nums[ptr2] == 2) ptr2--;

        for(int i=0; i<=ptr2; i++) {
            if(nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[ptr2];
                nums[ptr2] = temp;

                while(ptr2 >= 0 && nums[ptr2] == 2) ptr2--;
            }
        }
    }
}
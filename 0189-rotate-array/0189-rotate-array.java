class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        if(k == 0) return;

        for(int i=0; i<len/2; i++) {
            int temp = nums[i];
            nums[i] = nums[len-1-i];
            nums[len-1-i] = temp;
        }

        for(int i=0; i<k/2; i++) {
            int temp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = temp;
        }

        for(int i=k; i<(len+k)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[len+k-1-i];
            nums[len+k-1-i] = temp;
        }
    }
}
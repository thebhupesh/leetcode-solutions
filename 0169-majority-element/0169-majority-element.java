class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int maj = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != res) maj--;
            else maj++;

            if(maj <= 0) {
                res = nums[i];
                maj = 1;
            }
        }

        return res;
    }
}
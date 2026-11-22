class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;

        for(int i=0; i<len; i++) {
            int prev = 0;

            for(int j=i; j<len; j++) {
                prev += nums[j];
                if(prev == k) res++;
            }
        }

        return res;
    }
}
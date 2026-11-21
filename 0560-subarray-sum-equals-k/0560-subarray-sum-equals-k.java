class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;

        for(int i=0; i<len; i++) {
            int prev = nums[i];
            if(prev == k) res++;

            for(int j=i+1; j<len; j++) {
                prev += nums[j];
                if(prev == k) res++;
            }
        }

        return res;
    }
}
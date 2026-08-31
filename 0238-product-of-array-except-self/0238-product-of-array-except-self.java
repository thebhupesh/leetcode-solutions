class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;

        Arrays.fill(res,1);

        for(int i=1; i<nums.length; i++) {
            left *= nums[i-1];
            right *= nums[nums.length-i];

            res[i] *= left;
            res[nums.length-i-1] *= right;
        }

        return res;
    }
}
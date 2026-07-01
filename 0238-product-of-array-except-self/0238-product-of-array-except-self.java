class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,1);
        int fwd = 1;
        int bwd = 1;

        for(int i=1; i<n; i++) {
            fwd *= nums[i-1];
            bwd *= nums[n-i];

            res[i] = res[i]*fwd;
            res[n-i-1] = res[n-i-1]*bwd;
        }

        return res;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] fwd = new int[n];
        int[] bwd = new int[n];
        int[] res = new int[n];
        fwd[0] = 1;
        bwd[n-1] = 1;

        for(int i=1; i<n; i++) {
            fwd[i] = fwd[i-1]*nums[i-1];
            bwd[n-i-1] = bwd[n-i]*nums[n-i];

            res[i] = bwd[i]*fwd[i];
            res[n-i-1] = bwd[n-i-1]*fwd[n-i-1];
        }

        return res;
    }
}
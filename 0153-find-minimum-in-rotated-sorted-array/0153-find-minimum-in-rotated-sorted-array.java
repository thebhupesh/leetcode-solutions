class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] <= nums[len-1] && (mid == 0 || nums[mid] < nums[mid-1])) return nums[mid];
            else if(nums[mid] > nums[len-1]) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
}
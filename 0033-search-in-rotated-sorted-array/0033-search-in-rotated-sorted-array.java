class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        int k = n-1;
        
        while(l<=r) {
            int m = l + (r-l)/2;

            if(nums[m] >= nums[(n+m-1)%n] && nums[m] >= nums[(m+1)%n]) {
                k = m;
                break;
            } else if(nums[m] > nums[n-1]) {
                l = m+1;
            } else if(nums[m] < nums[n-1]) {
                r = m-1;
            }
        }

        if(target >= nums[0]) {
            l = 0;
            r = k;
        } else {
            l = k+1;
            r = n-1;
        }

        while(l<=r) {
            int m = l + (r-l)/2;

            if(nums[m] == target) return m;
            else if(nums[m] < target) l = m+1;
            else r = m-1;
        }

        return -1;
    }
}
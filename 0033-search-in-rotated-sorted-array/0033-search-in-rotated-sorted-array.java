class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;

        while(min<max) {
            int mid = min + (max-min)/2;

            if(nums[mid] > nums[nums.length-1]) min = mid+1;
            else max = mid;
        }

        if(target <= nums[nums.length-1]) {
            min = max;
            max = nums.length-1;
        } else {
            min = 0;
            max -= 1;
        }

        while(min<=max) {
            int mid = min + (max-min)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) min = mid+1;
            else max = mid-1;
        }

        return -1;
    }
}
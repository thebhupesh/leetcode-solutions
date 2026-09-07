class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)/2;

        while(left < right) {
            if(nums[mid] > 0) {
                if(mid > 0 && nums[mid-1] >= 0) right = mid-1;
                else break;
            } else if(nums[mid] < 0) left = mid+1;
            else break;

            mid = left + (right-left)/2;
        }

        left = mid-1;
        right = mid;

        int[] res = new int[nums.length];
        int i = 0;

        while(left >= 0 || right < nums.length) {
            if(left == -1) {
                res[i] = nums[right]*nums[right];
                right++;
            } else if(right == nums.length) {
                res[i] = nums[left]*nums[left];
                left--;
            } else {
                if(Math.abs(nums[left]) <= nums[right]) {
                    res[i] = nums[left]*nums[left];
                    left--;
                } else {
                    res[i] = nums[right]*nums[right];
                    right++;
                }
            }
            i++;
        }

        return res;
    }
}
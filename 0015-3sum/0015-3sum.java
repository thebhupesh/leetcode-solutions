class Solution {

    private int findIdx(int[]nums, int n, int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == n) {
                return mid;
            } else if(nums[mid] < n) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len-1;

        Set<List<Integer>> result = new HashSet<>();

        while(left < len-2) {
            int val = (nums[left]+nums[right])*(-1);
            int pos = findIdx(nums,val,left+1,right-1);

            if(pos != -1) {
                result.add(new ArrayList<>(List.of(nums[left],nums[pos],nums[right])));
            }

            if(right-left == 1) {
                left++;
                right = len;
            }

            right--;
        }

        return new ArrayList<>(result);
    }
}
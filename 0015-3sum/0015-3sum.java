class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {
            int target = -(nums[i]);

            if(nums[i] > 0) break; 

            if(i>0 && nums[i] == nums[i-1]) continue;

            int m = i+1;
            int n = nums.length-1;

            while(m<n) {
                int val = nums[m]+nums[n];
                if(val == target) {
                    res.add(List.of(nums[i],nums[m],nums[n]));

                    m++;
                    n--;

                    while(m < n && nums[m] == nums[m-1]) m++;
                    while(n > m && nums[n] == nums[n+1]) n--;
                } else if(val > target) n--;
                else m++;
            }
        }

        return res;
    }
}
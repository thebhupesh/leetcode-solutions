class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for(int i=0; i<nums.length-3; i++) {
            for(int j=i+1; j<nums.length-2; j++) {
                int p1 = j+1;
                int p2 = nums.length-1;

                while(p1<p2) {
                    long sum = (long)nums[i]+nums[j]+nums[p1]+nums[p2];

                    if(sum == target) {
                        res.add(List.of(nums[i],nums[j],nums[p1],nums[p2]));
                        p1++;
                        p2--;
                    }
                    else if(sum > target) p2--;
                    else p1++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for(int i=0; i<nums.length-3;) {
            for(int j=i+1; j<nums.length-2;) {
                int p1 = j+1;
                int p2 = nums.length-1;

                while(p1<p2) {
                    long sum = (long)nums[i]+nums[j]+nums[p1]+nums[p2];

                    if(sum == target) {
                        res.add(List.of(nums[i],nums[j],nums[p1],nums[p2]));
                        int curr = nums[p2];
                        while(p2 >= 0 && nums[p2] == curr) p2--;
                        curr = nums[p1];
                        while(p1 < nums.length && nums[p1] == curr) p1++;
                    }
                    else if(sum > target) {
                        int curr = nums[p2];
                        while(p2 >= 0 && nums[p2] == curr) p2--;
                    }
                    else {
                        int curr = nums[p1];
                        while(p1 < nums.length && nums[p1] == curr) p1++;
                    }
                }

                int curr = nums[j];
                while(j < nums.length-2 && nums[j] == curr) j++;
            }
            int curr = nums[i];
            while(i < nums.length-3 && nums[i] == curr) i++;
        }

        return new ArrayList<>(res);
    }
}
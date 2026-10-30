class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if(len < 4) return res;

        Arrays.sort(nums);
        
        for(int i=0; i<len-3;) {
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) break;
            int curr = -1;
            
            for(int j=i+1; j<len-2;) {
                int p1 = j+1;
                int p2 = len-1;

                while(p1 < p2) {
                    long sum = (long)nums[i]+nums[j]+nums[p1]+nums[p2];

                    if(sum == target) {
                        res.add(List.of(nums[i],nums[j],nums[p1],nums[p2]));
                        
                        curr = nums[p2];
                        while(p1 < p2 && nums[p2] == curr) p2--;
                        
                        curr = nums[p1];
                        while(p1 < p2 && nums[p1] == curr) p1++;
                    }
                    else if(sum > target) {
                        curr = nums[p2];
                        while(p1 < p2 && nums[p2] == curr) p2--;
                    }
                    else {
                        curr = nums[p1];
                        while(p1 < p2 && nums[p1] == curr) p1++;
                    }
                }

                curr = nums[j];
                while(j < len-2 && nums[j] == curr) j++;
            }
            
            curr = nums[i];
            while(i < len-3 && nums[i] == curr) i++;
        }

        return res;
    }
}
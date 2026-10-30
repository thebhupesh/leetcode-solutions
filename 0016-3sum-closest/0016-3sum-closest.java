class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = 0, diff = Integer.MAX_VALUE;

        for(int i=0; i<nums.length-2; i++) {
            int p1 = i+1;
            int p2 = nums.length-1;

            while(p1<p2) {
                int sum = nums[i]+nums[p1]+nums[p2];
                if(Math.abs(target-sum) < diff) {
                    res = sum;
                    diff = Math.abs(target-sum);
                }

                if(sum > target) p2--;
                else if(sum < target) p1++;
                else break;
            }

            if(res == target) break;
        }

        return res;
    }
}
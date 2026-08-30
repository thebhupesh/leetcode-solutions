class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;

        int start = nums[0];
        int last = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > last+1) {
                if(start == last) res.add(start+"");
                else res.add(start+"->"+last);

                start = nums[i];
            }
            last = nums[i];
        }

        if(start == last) res.add(start+"");
        else res.add(start+"->"+last);

        return res;
    }
}
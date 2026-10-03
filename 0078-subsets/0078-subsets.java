class Solution {
    
    private List<List<Integer>> solve(int[] nums, int pos, List<List<Integer>> lists) {
        if(pos == nums.length) return lists;

        List<List<Integer>> tempRes = new ArrayList<>(lists);

        for(List<Integer> list : lists) {
            List<Integer> temp = new ArrayList<>(list);
            list.add(nums[pos]);
            tempRes.add(temp);
        }

        return solve(nums, pos+1, tempRes);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return solve(nums, 0, new ArrayList<>(List.of(new ArrayList<>())));
    }
}
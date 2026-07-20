class Solution {
    private void findPermutations(List<List<Integer>> perms, int val) {
        List<List<Integer>> newPerms = new ArrayList<>();
        
        for(int i=0; i<perms.size(); i++) {
            List<Integer> curr = perms.get(i);
            curr.add(val);
            
            for(int j=0; j<curr.size()-1; j++) {
                List<Integer> newPerm = new ArrayList<>(curr);
                newPerm.set(newPerm.size()-1, newPerm.get(j));
                newPerm.set(j, val);
                newPerms.add(newPerm);
            }
        }

        perms.addAll(newPerms);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(nums[0])));

        for(int i=1; i<nums.length; i++) findPermutations(res, nums[i]);

        return res;
    }
}
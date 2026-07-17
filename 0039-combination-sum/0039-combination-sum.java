class Solution {
    private void findCombinations(int[] list, int idx, int val, int target, List<List<Integer>> res, List<Integer> curr) {
        for(int i=idx; i<list.length; i++) {
            boolean rtrn = false;
            int temp = val+list[i];
            curr.add(list[i]);
            
            if(temp+list[i] <= target) findCombinations(list, i, temp, target, res, curr);
            else if(temp == target) {
                res.add(new ArrayList<>(curr));
                rtrn = true;
            } else if(temp > target) rtrn = true;

            curr.remove(curr.size()-1);

            if(rtrn) return;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        findCombinations(candidates, 0, 0, target, res, new ArrayList<>());

        return res;
    }
}
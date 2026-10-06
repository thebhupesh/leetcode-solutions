class Solution {
    private void findCombinations(List<List<Integer>> res, int[] candidates, int pos, int curr, int target, List<Integer> combination) {
        for(int i=pos; i<candidates.length; i++) {
            List<Integer> list = new ArrayList<>(combination);
            int temp = curr+candidates[i];
            list.add(candidates[i]);

            if(temp == target) res.add(list);
            else if(temp < target) findCombinations(res, candidates, i, temp, target, list);
            else return;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        findCombinations(res, candidates, 0, 0, target, new ArrayList<>());

        return res;
    }
}
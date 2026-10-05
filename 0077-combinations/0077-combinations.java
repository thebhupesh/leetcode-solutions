class Solution {
    private void findCombinations(List<List<Integer>> res, int val, int n, int k, List<Integer> combination) {
        combination.add(val);

        if(combination.size() == k) {
            res.add(combination);
            return;
        }

        for(int i=val+1; i<=n-k+combination.size()+1; i++) {
            List<Integer> temp = new ArrayList<>(combination);
            findCombinations(res, i, n, k, temp);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=n-k+1; i++) findCombinations(res, i, n, k, new ArrayList<>());

        return res;
    }
}
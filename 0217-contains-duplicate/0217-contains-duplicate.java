class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();

        for(int n : nums) {
            if(vals.contains(n)) return true;
            vals.add(n);
        }

        return false;
    }
}
class Solution {
    Set<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int idx = 0;
        int pos = 0;

        while(idx < len) {
            while(pos < len) {
                int[] temp = Arrays.copyOf(nums, len);

                int val = temp[idx];
                temp[idx] = temp[pos];
                temp[pos] = val;

                List<Integer> tempList = new ArrayList<>(Arrays.stream(temp).boxed().toList());

                if(!set.contains(tempList)) {
                    set.add(tempList);
                    set.addAll(permute(temp));
                }

                pos++;
            }

            idx++;
            pos = idx+1;
        }

        return new ArrayList<>(set);
    }
}
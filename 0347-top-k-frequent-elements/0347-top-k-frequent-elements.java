class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer>[] vals = new HashSet[nums.length+1];
        Map<Integer,Integer> counts = new HashMap<>();

        for(int num : nums) {
            int count = counts.getOrDefault(num,0);
            if(count > 0) vals[count].remove(num);
            else vals[count] = new HashSet<>();
            if(vals[count+1] == null) vals[count+1] = new HashSet<>();
            vals[count+1].add(num);
            counts.put(num,count+1);
        }

        int itr = nums.length;
        List<Integer> res = new ArrayList<>();

        while(k > 0) {
            if(vals[itr] != null ) {
                res.addAll(vals[itr]);
                k -= vals[itr].size();
            }
            itr--;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
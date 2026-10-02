class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer>[] vals = new HashSet[nums.length+1];
        int[] counts = new int[20001];

        for(int num : nums) {
            int count = counts[num+10000];
            
            if(count > 0) vals[count].remove(num);
            if(vals[count+1] == null) vals[count+1] = new HashSet<>();
            vals[count+1].add(num);
            counts[num+10000]++;
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
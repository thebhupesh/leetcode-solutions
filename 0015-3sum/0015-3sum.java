class Solution {
    private String toString(List<Integer> nums) {
        return nums.get(0)+","+nums.get(1)+","+nums.get(2);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> s = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : nums) {
            s.put(n, s.getOrDefault(n,0)+1);
            
            min = Math.min(min,n);
            max = Math.max(max,n);
        }

        if(min > 0 || max < 0) return res;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] >= 0) break;
            
            for(int j=nums.length-1; j>i; j--) {
                
                int val = (-1)*(nums[i]+nums[j]);
                int n = 1;

                if(val == nums[i]) n++;
                if(val == nums[j]) n++;

                if(s.getOrDefault(val,0) >= n) {
                    List<Integer> curr = new ArrayList<>(List.of(nums[i],val,nums[j]));
                    Collections.sort(curr);
                    String str = toString(curr);
                    
                    if(!visited.contains(str)) {
                        res.add(curr);
                        visited.add(str);
                    }
                }
            }
        }

        if(s.getOrDefault(0,0) >= 3) res.add(List.of(0,0,0));

        return res;
    }
}
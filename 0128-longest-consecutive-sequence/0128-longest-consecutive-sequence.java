class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;

        for(int n : nums) s.add(n);

        for(int n : s) {
            if(!s.contains(n-1)) {
                int len = 1;

                while(s.contains(n+len)) len++;

                res = Math.max(res, len);
            }
        }

        return res;
    }
}
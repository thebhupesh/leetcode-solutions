class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int start = 0;
        int res = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(mp.containsKey(c)) {
                int val = mp.get(c);
                if(val >= start) start = val+1;
            }

            res = Math.max(res, i-start+1);
            mp.put(c,i);
        }

        return res;
    }
}
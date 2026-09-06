class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m = new HashMap<>();

        int len = 0;
        int start = 0;

        for(int i=0; i<s.length(); i++) {
            int pos = m.getOrDefault(s.charAt(i),-1);

            if(pos != -1 && pos >= start) {
                len = Math.max(len,i-start);
                start = pos+1;
            }
            m.put(s.charAt(i),i);
        }

        return Math.max(len,s.length()-start);
    }
}
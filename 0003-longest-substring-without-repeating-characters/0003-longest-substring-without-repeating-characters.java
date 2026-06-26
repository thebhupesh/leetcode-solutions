class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int currLength = 0;
        int maxLength = 0;
        int startIdx = 0;

        for(char ch : s.toCharArray()) {
            if(mp.containsKey(ch)) {
                int val = mp.get(ch);

                mp.put(ch, startIdx+currLength);

                if(val < startIdx) {
                    currLength++;
                } else {
                    currLength -= (val-startIdx);
                    startIdx = val+1;
                }
            } else {
                mp.put(ch, startIdx+currLength);
                currLength++;
            }

            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
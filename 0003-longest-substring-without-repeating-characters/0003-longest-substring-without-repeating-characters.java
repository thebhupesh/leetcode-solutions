class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int currLength = 0;
        int maxLength = 0;
        int startIdx = 0;

        for(char ch : s.toCharArray()) {
            int val = mp.getOrDefault(ch,-1);

            mp.put(ch, startIdx+currLength);

            if(val != -1) {
                if(val < startIdx) {
                    currLength++;
                } else {
                    maxLength = Math.max(maxLength, currLength);
                    currLength -= (val-startIdx);
                    startIdx = val+1;
                }
            } else {
                currLength++;
            }
        }

        return Math.max(maxLength,currLength);
    }
}
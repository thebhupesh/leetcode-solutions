class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        int singleCount = 0;

        Map<Character,Integer> m = new HashMap<>();

        for(char c : s.toCharArray()) {
            int val = m.getOrDefault(c,0)+1;
            m.put(c,val);

            if(val%2 != 0) singleCount++;
            else {
                count += 2;
                singleCount--;
            }
        }

        return (singleCount > 0) ? ++count : count;
    }
}
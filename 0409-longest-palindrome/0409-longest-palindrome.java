class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int val = 0;
        int odds = 0;

        for(char ch : s.toCharArray()) {
            int temp = (mp.containsKey(ch)) ? mp.get(ch) : 0;
            
            if(temp%2 == 0) {
                odds++;
            }
            else {
                val += 2;
                odds--;
            }

            mp.put(ch,temp+1);
        }

        return (odds>0) ? val+1 : val;
    }
}
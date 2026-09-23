class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] counts = new int[26];
        int max = 0;
        int res = 0;

        for(int i=0; i<s.length(); i++) {
            counts[s.charAt(i)-'A']++;

            for(int count : counts) max = Math.max(max,count);

            if((i-left+1)-max > k) {
                counts[s.charAt(left)-'A']--;
                left++;
            } else {
                res = Math.max(res, i-left+1);
            }
        }

        return res;
    }
}
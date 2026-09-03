class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];

        for(char c : text.toCharArray()) chars[c-'a']++;

        int res = Integer.MAX_VALUE;

        for(char c : "balon".toCharArray()) {
            if(c == 'l' || c == 'o') res = Math.min(res,chars[c-'a']/2);
            else res = Math.min(res,chars[c-'a']);
        }

        return res;
    }
}
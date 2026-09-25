class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];

        for(char c : s1.toCharArray()) count[c-'a']++;

        int[] curr = new int[26];
        int left = 0;
        int right = 0;

        while(right < s2.length()) {
            char c = s2.charAt(right);
            curr[c-'a']++;

            if((right-left+1) == s1.length()) {
                boolean flag = true;

                for(int i=0; i<26; i++) {
                    if(count[i] != curr[i]) {
                        curr[s2.charAt(left)-'a']--;
                        left++;
                        flag = false;
                        break;
                    }
                }

                if(flag) return flag;
            }

            right++;
        }

        return false;
    }
}
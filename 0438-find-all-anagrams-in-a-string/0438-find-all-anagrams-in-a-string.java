class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();

        if(sLen < pLen) return res;
        
        int pos = 0;
        int[] reqCounts = new int[26];
        int[] currCounts = new int[26];

        for(char c : p.toCharArray()) reqCounts[c-'a']++;

        for(int i=0; i<s.length(); i++) {
            currCounts[s.charAt(i)-'a']++;

            if((i+1)>=p.length()) {
                boolean isAnagram = true;
                for(int j=0; j<26; j++) {
                    if(currCounts[j] != reqCounts[j]) {
                        isAnagram = false;
                        break;
                    }
                }

                if(isAnagram) res.add(pos);

                currCounts[s.charAt(pos)-'a']--;
                pos++;
            }
        }

        return res;
    }
}
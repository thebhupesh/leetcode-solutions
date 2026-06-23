class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ch = new int[26];

        for(char c : magazine.toCharArray()) {
            ch[c-'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(--ch[c-'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
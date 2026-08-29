class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int len1 = word1.length();
        int len2 = word2.length();

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1<len1 || ptr2<len2) {
            if(ptr1<len1) str.append(word1.charAt(ptr1++));
            if(ptr2<len2) str.append(word2.charAt(ptr2++));
        }

        return str.toString();
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        int ptr1 = 0;
        int ptr2 = s.length()-1;

        while(ptr1 < ptr2) {
            while(ptr1<s.length() && !Character.isLetter(s.charAt(ptr1)) && !Character.isDigit(s.charAt(ptr1))) ptr1++;
            while(ptr2>=0 && !Character.isLetter(s.charAt(ptr2)) && !Character.isDigit(s.charAt(ptr2))) ptr2--;

            if(ptr1<ptr2 && Character.toLowerCase(s.charAt(ptr1)) != Character.toLowerCase(s.charAt(ptr2))) return false;

            ptr1++;
            ptr2--;
        }

        return true;
    }
}
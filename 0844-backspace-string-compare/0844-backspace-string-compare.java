class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length()-1;
        int p2 = t.length()-1;

        int b1 = 0;
        int b2 = 0;

        while(p1 >= 0 || p2 >= 0) {
            while(p1 >= 0) {
                if(s.charAt(p1) == '#') b1++;
                else {
                    if(b1 > 0) b1--;
                    else break;
                }
                p1--;
            }
            
            while(p2 >= 0) {
                if(t.charAt(p2) == '#') b2++;
                else {
                    if(b2 > 0) b2--;
                    else break;
                }
                p2--;
            }

            if((p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2)) || (p1 < 0 && p2 >= 0) || (p1 >= 0 && p2 < 0)) return false;

            p1--;
            p2--;
        }

        return true;
    }
}
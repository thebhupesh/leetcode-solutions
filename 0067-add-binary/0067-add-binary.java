class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder s = new StringBuilder();
        int aLen = a.length(), bLen = b.length();
        char[] aStr = null, bStr = null;
        
        if(aLen >= bLen) {
            aStr = a.toCharArray();
            bStr = b.toCharArray();
        } else {
            aStr = b.toCharArray();
            bStr = a.toCharArray();

            aLen = aStr.length;
            bLen = bStr.length;
        }

        while(aLen > 0 || bLen > 0) {
            int curr = carry;
            
            if(--aLen >= 0) {
                if(aStr[aLen] == '1' && curr == 1) {
                    curr = 0;
                } else if(aStr[aLen] == '1' && curr == 0) {
                    curr = 1;
                } else if(aStr[aLen] == '0' && curr == 1) {
                    carry = 0;
                }
            }

            if(--bLen >= 0) {
                if(bStr[bLen] == '1' && curr == 1) {
                    curr = 0;
                    carry = 1;
                } else if(bStr[bLen] == '1' && curr == 0) {
                    curr = 1;
                }
            }

            s.append(curr);
        }

        if(carry == 1) s.append(carry);

        return s.reverse().toString();
    }
}
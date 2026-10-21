class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        StringBuilder res = new StringBuilder();

        int aPos = a.length()-1;
        int bPos = b.length()-1;

        while(aPos >= 0 || bPos >= 0) {
            int ones = (carry) ? 1 : 0;

            if(aPos >= 0) {
                if(a.charAt(aPos--) == '1') ones++;
            }
            if(bPos >= 0) {
                if(b.charAt(bPos--) == '1') ones++;
            }

            if(ones%2 == 0) res.append(0);
            else res.append(1);

            if(ones > 1) carry = true;
            else carry = false;
        }

        if(carry) res.append(1);

        return res.reverse().toString();
    }
}
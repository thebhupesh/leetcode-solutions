class Solution {
    public int myAtoi(String s) {
        int maxRes = Integer.MAX_VALUE;
        int minRes = Integer.MIN_VALUE;

        StringBuilder str = new StringBuilder();
        boolean isNegative = false;
        boolean gotSign = false;

        for(char c : s.toCharArray()) {
            if(str.length() == 0) {
                if(c == ' ' && !gotSign) continue;
                else if((c == '-' || c == '+') && !gotSign) {
                    isNegative = (c == '-');
                    gotSign = true;
                }
                else if(c-'0' >= 0 & c-'0' <= 9) str.append(c);
                else break;
            } else if(c-'0' >= 0 & c-'0' <= 9) str.append(c);
            else break;
        }

        int len = str.length();
        if(len == 0) return 0;

        int zeros = 0;
        while(zeros<len && str.charAt(zeros) == '0') zeros++;
        if(str.length()-zeros > 10) return (isNegative) ? minRes : maxRes;

        long mul = 1;
        long res = 0;

        for(int i=str.length()-1; i>=zeros; i--) {
            res += ((str.charAt(i)-'0')*mul);
            mul *= 10;
        }

        if(isNegative) res *= (-1);

        return (res <= maxRes && res >= minRes) ? (int)res : ((isNegative) ? minRes : maxRes);
    }
}
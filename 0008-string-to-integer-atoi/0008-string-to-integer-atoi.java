class Solution {
    public int myAtoi(String s) {
        long maxRes = Integer.MAX_VALUE;
        long minRes = Integer.MIN_VALUE;

        boolean isNegative = false;
        boolean gotValid = false;

        long res = 0;

        for(char c : s.toCharArray()) {
            if(!gotValid) {
                if(c == ' ') continue;
                else if(c == '-' || c == '+') {
                    isNegative = (c == '-');
                    gotValid = true;
                }
                else if(c >= '0' && c <= '9') {
                    res = (res*10) + (c-'0');
                    gotValid = true;
                }
                else return 0;
            } else if(c >= '0' && c <= '9') {
                res = (res*10) + (c-'0');

                if(isNegative && res > maxRes+1) return (int)minRes;
                else if(!isNegative && res > maxRes) return (int)maxRes;
            }
            else break;
        }

        return (isNegative) ? (int)res*(-1) : (int)res;
    }
}
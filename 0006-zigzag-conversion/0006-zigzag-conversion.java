class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder str = new StringBuilder();
        int jump = (numRows-1)*2;
        int len = s.length();

        for(int i=0; i<numRows; i++) {
            int pos = i;
            int currJump = jump - 2*i;
            
            while(pos < len) {
                if(currJump == 0) currJump = jump;
                
                str.append(s.charAt(pos));
                
                pos += currJump;
                currJump = jump-currJump;
            }
        }

        return str.toString();
    }
}
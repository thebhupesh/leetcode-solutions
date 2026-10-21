class Solution {
    public String convertToBase7(int num) {
        StringBuilder str = new StringBuilder();
        int val = Math.abs(num);

        while(val >= 7) {
            str.insert(0,val%7);
            val /= 7;
        }

        str.insert(0,val);
        if(num < 0) str.insert(0,'-');

        return str.toString();
    }
}
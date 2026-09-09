class Solution {
    private long findValue(long num, long div, int multiplier) {
        return (((num/div) - 1)*div + (num%div) + 1)*multiplier;
    }

    public long countCommas(long n) {
        if(n < 1_000) return 0;
        
        long val = 0;

        if(n > 999_999) val += 999_000;
        else return findValue(n,1_000,1);

        if(n > 999_999_999) val += 999_000_000*2;
        else return val + findValue(n,1_000_000,2);

        if(n > 999_999_999_999L) val += 999_000_000_000L*3;
        else return val + findValue(n,1_000_000_000L,3);

        if(n > 999_999_999_999_999L) return val + 999_000_000_000_000L*4+5;
        else return val + findValue(n,1_000_000_000_000L,4);
    }
}
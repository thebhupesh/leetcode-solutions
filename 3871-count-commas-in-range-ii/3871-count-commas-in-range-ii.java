class Solution {
    private long findValue(long num, long div) {
        return ((num/div) - 1)*div + (num%div) + 1;
    }

    public long countCommas(long n) {
        if(n <= 999) return 0;
        else if(n <= 999_999) return findValue(n,1_000);
        else if(n <= 999_999_999) return 999_000L + findValue(n,1_000_000)*2;
        else if(n <= 999_999_999_999L) return 999_000L + 999_000_000L*2 + findValue(n,1_000_000_000L)*3;
        else if(n <= 999_999_999_999_999L) return 999_000L + 999_000_000L*2 + 999_000_000_000L*3 + findValue(n,1_000_000_000_000L)*4;
        else return 3998998998999005L;
    }
}
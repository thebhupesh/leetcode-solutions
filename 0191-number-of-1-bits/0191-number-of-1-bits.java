class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        while(n > 0) {
            int temp = n;
            n >>= 1;
            n <<= 1;

            if((n^temp) == 1) res++;
            
            n >>= 1;
        }

        return res;
    }
}
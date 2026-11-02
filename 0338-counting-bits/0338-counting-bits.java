class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<=n; i++) {
            int curr = i;
            int cnt = 32;

            while(cnt-- > 0) {
                if((curr^((curr >> 1) << 1)) == 1) res[i]++;
                curr = curr >> 1;
            }
        }

        return res;
    }
}
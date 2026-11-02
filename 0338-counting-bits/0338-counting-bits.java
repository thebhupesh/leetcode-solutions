class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<=n; i++) {
            int curr = i;
            int cnt = 32;

            while(cnt > 0) {
                int temp = curr >> 1;
                temp = temp << 1;
                
                if((curr^temp) == 1) res[i]++;

                curr = temp >> 1;

                cnt--;
            }
        }

        return res;
    }
}
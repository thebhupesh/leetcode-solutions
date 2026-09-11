class Solution {

    public int totalNumbers(int[] digits) {
        int[] counts = new int[10];
        int[][] dp = new int[10][10];
        int count = 0;

        for(int digit : digits) counts[digit]++;        

        for(int digit_0=0; digit_0<=8; digit_0+=2) {
            if(counts[digit_0] > 0) {
                counts[digit_0]--;

                for(int digit_1=0; digit_1<=9; digit_1++) {
                    if(dp[digit_0][digit_1] != 0) count += dp[digit_0][digit_1];
                    else if(counts[digit_1] > 0) {
                        counts[digit_1]--;

                        int cnt = 0;
                        
                        for(int digit_2=1; digit_2<=9; digit_2++) {
                            if(counts[digit_2] > 0) cnt++;
                        }

                        dp[digit_1][digit_0] = cnt;

                        count += cnt;

                        counts[digit_1]++;
                    }
                }

                counts[digit_0]++;
            }
        }

        return count;
    }
}
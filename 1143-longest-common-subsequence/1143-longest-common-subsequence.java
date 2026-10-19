class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        int res = 0;

        int pos1 = 1;
        int pos2 = 1;

        while(pos1 <= len1) {
            int temp = pos2;
            while(temp <= len2) {
                if(text1.charAt(pos1-1) == text2.charAt(temp-1)) {
                    dp[pos1][temp] = dp[pos1-1][temp-1]+1;
                    res = Math.max(res,dp[pos1][temp]);
                } else {
                    dp[pos1][temp] = Math.max(dp[pos1-1][temp], dp[pos1][temp-1]);
                }
                temp++;
            }
            pos1++;
        }

        return res;
    }
}
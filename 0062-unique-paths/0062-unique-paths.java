class Solution {
    private int[][] dp;

    public int uniquePaths(int m, int n) {
        if(dp == null) {
            dp = new int[m][n];
            return uniquePaths(m-1,n-1);
        }
        if(m == 0 && n == 0) return 1;
        else if(m<0 || n<0) return 0;
        if(dp[m][n] != 0) return dp[m][n];

        return dp[m][n] = uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }
}
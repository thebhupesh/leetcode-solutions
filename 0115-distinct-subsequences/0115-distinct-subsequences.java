class Solution {
    private int getDistincts(String s, String t, int lenS, int lenT, int i, int j, int[][] dp) {
        if(j == lenT) return 1;
        if(i == lenS) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int val = getDistincts(s,t,lenS,lenT,i+1,j,dp);

        if(s.charAt(i) == t.charAt(j)) val += getDistincts(s,t,lenS,lenT,i+1,j+1,dp);

        dp[i][j] = val;

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int[][] dp = new int[lenS][lenT];


        for(int i=0; i<lenS; i++) {
            Arrays.fill(dp[i],-1);
        }

        return getDistincts(s,t,lenS,lenT,0,0,dp);
    }
}
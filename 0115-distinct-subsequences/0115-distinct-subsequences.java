class Solution {
    private int getDistincts(String s, String t, int i, int j, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        int val = 0;

        for(int x=i; x<=s.length()-t.length()+j; x++) {
            if(s.charAt(x) == t.charAt(j)) {
                if(j+1 == t.length()) val++;
                else if(x+1 != s.length()) val += getDistincts(s,t,x+1,j+1,dp);
            }
        }

        dp[i][j] = val;

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];

        for(int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i],-1);
        }

        return getDistincts(s,t,0,0,dp);
    }
}
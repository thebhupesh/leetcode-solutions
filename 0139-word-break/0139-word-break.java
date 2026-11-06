class Solution {
    private int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        if(dp == null) {
            dp = new int[len+1];
            Arrays.fill(dp,-1);
        }

        if(len == 0) return true;
        if(dp[len] != -1) return dp[len] == 1;

        for(String word : wordDict) {
            if(s.indexOf(word) == 0 && wordBreak(s.substring(word.length(),len),wordDict)) {
                dp[len] = 1;
                return true;
            }
        }

        dp[len] = 0;
        return false;
    }
}
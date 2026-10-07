class Solution {
    private void generate(int n, int open, int close, List<String> res, String current) {
        if(open == close && open == n) res.add(current);
        else {
            if(open < n) generate(n, open+1, close, res, current+"(");
            if(close < open) generate(n, open, close+1, res, current+")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(n, 1, 0, res, "(");

        return res;
    }
}
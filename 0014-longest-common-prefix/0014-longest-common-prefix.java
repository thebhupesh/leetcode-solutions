class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder("");

        for(int i=0;;i++) {
            boolean exit = false;

            for(String s : strs) {
                if(i==s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    exit = true;
                    break;
                }
            }

            if(exit) break;
            else res.append(strs[0].charAt(i));
        }

        return res.toString();
    }
}
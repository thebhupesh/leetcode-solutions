class Solution {
    private String process(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }
}
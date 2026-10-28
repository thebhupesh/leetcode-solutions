class Solution {
    private StringBuilder process(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }

        return sb;
    }

    public boolean backspaceCompare(String s, String t) {
        return process(s).compareTo(process(t)) == 0;
    }
}
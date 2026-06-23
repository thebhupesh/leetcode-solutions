class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int len = s.length();

        for(int i=0; i<len; i++) {
            Character ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (st.empty()) {
                return false;
            } else if(ch == ')' && st.pop() != '(') {
                return false;
            } else if(ch == '}' && st.pop() != '{') {
                return false;
            } else if(ch == ']' && st.pop() != '[') {
                return false;
            }
        }

        if(!st.empty()) {
            return false;
        }

        return true;
    }
}
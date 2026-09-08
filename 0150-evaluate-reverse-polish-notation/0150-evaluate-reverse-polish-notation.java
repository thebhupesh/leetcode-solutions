class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) s.push(String.valueOf(Integer.parseInt(s.pop())+Integer.parseInt(s.pop())));
            else if(token.equals("*")) s.push(String.valueOf(Integer.parseInt(s.pop())*Integer.parseInt(s.pop())));
            else if(token.equals("-")) {
                String top = s.pop();
                s.push(String.valueOf(Integer.parseInt(s.pop())-Integer.parseInt(top)));
            } else if(token.equals("/")) {
                String top = s.pop();
                s.push(String.valueOf(Integer.parseInt(s.pop())/Integer.parseInt(top)));
            } else s.push(token);
        }

        return Integer.parseInt(s.pop());
    }
}
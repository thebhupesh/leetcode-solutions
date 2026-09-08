class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) s.push(s.pop()+s.pop());
            else if(token.equals("*")) s.push(s.pop()*s.pop());
            else if(token.equals("-")) {
                int top = s.pop();
                s.push(s.pop()-top);
            } else if(token.equals("/")) {
                int top = s.pop();
                s.push(s.pop()/top);
            } else s.push(Integer.parseInt(token));
        }

        return s.pop();
    }
}
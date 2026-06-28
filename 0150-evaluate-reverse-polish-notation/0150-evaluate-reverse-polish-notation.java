class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String tkn : tokens) {
            if(tkn.equals("+")) {
                int op1 = s.pop();
                int op2 = s.pop();

                s.push(op2+op1);
            } else if(tkn.equals("-")) {
                int op1 = s.pop();
                int op2 = s.pop();

                s.push(op2-op1);
            } else if(tkn.equals("/")) {
                int op1 = s.pop();
                int op2 = s.pop();

                s.push(op2/op1);
            } else if(tkn.equals("*")) {
                int op1 = s.pop();
                int op2 = s.pop();

                s.push(op2*op1);
            } else {
                s.push(Integer.parseInt(tkn));
            }
        }

        return s.pop();
    }
}
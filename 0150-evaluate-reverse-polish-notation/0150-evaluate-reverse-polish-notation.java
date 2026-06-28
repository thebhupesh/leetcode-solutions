class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String tkn : tokens) {
            try {
                s.push(Integer.parseInt(tkn));
            } catch(NumberFormatException e) {
                int op1 = s.pop();
                int op2 = s.pop();

                if(tkn.equals("+")) s.push(op2+op1);
                else if(tkn.equals("-")) s.push(op2-op1);
                else if(tkn.equals("/")) s.push(op2/op1);
                else if(tkn.equals("*")) s.push(op2*op1);
            }
        }

        return s.pop();
    }
}
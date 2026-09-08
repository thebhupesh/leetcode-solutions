class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();

        for(String token : tokens) {
            if(token.equals("+")) s.offerFirst(s.pollFirst()+s.pollFirst());
            else if(token.equals("*")) s.offerFirst(s.pollFirst()*s.pollFirst());
            else if(token.equals("-")) {
                int top = s.pollFirst();
                s.offerFirst(s.pollFirst()-top);
            } else if(token.equals("/")) {
                int top = s.pollFirst();
                s.offerFirst(s.pollFirst()/top);
            } else s.offerFirst(Integer.parseInt(token));
        }

        return s.peekFirst();
    }
}
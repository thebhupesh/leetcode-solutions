class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char curr : s.toCharArray()) {
            if(curr == '(' || curr == '{' || curr == '[') stack.push(curr);
            else if(curr == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            else if(curr == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            else if(curr == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
        }

        return stack.isEmpty();
    }
}
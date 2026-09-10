class MinStack {
    class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Deque<Node> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        if(stack.size() > 0) stack.push(new Node(value,Math.min(value,stack.peek().min)));
        else stack.push(new Node(value,value));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
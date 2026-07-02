class Node {
    int val;
    int min;
    Node prev;

    Node(int v, int m, Node n) {
        val = v;
        min = m;
        prev = n;
    }
}

class MinStack {
    Node stack;
    int min;

    public MinStack() {
        stack = null;
    }
    
    public void push(int value) {
        Node newNode = new Node(value, (stack == null) ? value : Math.min(stack.min,value), stack);
        stack = newNode;
    }
    
    public void pop() {
        stack = stack.prev;
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
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
class MyQueue {
    Stack<Integer> q;
    int front;

    public MyQueue() {
        q = new Stack<>();
        front = -1;
    }
    
    public void push(int x) {
        if(front == -1) front = x;
        q.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();

        while(!q.isEmpty()) {
            temp.push(q.pop());
        }

        int val = temp.pop();

        if(!temp.isEmpty()) front = temp.peek();
        else front = -1;

        while(!temp.isEmpty()) {
            q.push(temp.pop());
        }

        return val;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return front == -1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
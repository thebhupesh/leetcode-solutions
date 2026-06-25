class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;
    int size;

    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        while(!main.isEmpty()) {
            helper.push(main.pop());
        }

        main.push(x);

        while(!helper.isEmpty()) {
            main.push(helper.pop());
        }

        size++;
    }
    
    public int pop() {
        size--;
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return size == 0;
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
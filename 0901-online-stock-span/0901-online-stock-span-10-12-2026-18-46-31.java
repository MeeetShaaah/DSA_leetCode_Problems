class StockSpanner {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StockSpanner() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!stack1.isEmpty() && price >= stack1.peek()){
        stack1.pop();   
        span += stack2.pop();
        }

        stack1.push(price);
        stack2.push(span);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
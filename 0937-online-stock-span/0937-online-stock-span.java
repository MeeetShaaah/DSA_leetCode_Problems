class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();    
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }

        stack.push(new int[]{price,span});
        return span;
    }
}

// approch - 1, brute force will be like, for every comming element, we can start seraching from day 1 for consecutive sequence, if breaks, start from 1 till current day. or  we can search backward to the next grater price,

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
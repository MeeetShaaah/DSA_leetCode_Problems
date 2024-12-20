// Approch - 2, i dont understand the 2*value - min
// class MinStack {
//     Stack<Long> stack = new Stack<>();
//     Long min;
//     public MinStack() {
//         min = Long.MAX_VALUE;
//     }
    
//     public void push(int val) {
//         Long value = Long.valueOf(val);

//         if(stack.isEmpty()){
//             min = value;
//             stack.push(value);
//         }else{
//             if(value < min){
//                 stack.push(2*value - min);
//                 min = value;
//             }else{
//                 stack.push(value);
//             }
//         }
//     }
    
//     public void pop() {
//         if(stack.isEmpty()) return;

//         Long value = stack.pop();

//         if(value < min){
//             min = 2 * min -value;
//         }
//     }
    
//     public int top() {
//         Long value = stack.peek();

//         if(value < min){
//             return min.intValue();
//         }
//         return value.intValue();
//     }
    
//     public int getMin() {
//         return min.intValue();
//     }
// }

// Using extra space,

class MinStack {
Stack<Integer> stack = new Stack<>();
Stack<Integer> minStack = new Stack<>();

    public MinStack() {        
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int mod = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < arr.length; i++){
            
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;

            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < arr.length; i++){
            long current = (long) left[i] * right[i] * arr[i];

            sum = (sum + current) % mod;
        }

        return (int)sum;
    }
}
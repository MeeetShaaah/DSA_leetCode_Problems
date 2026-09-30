class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int mod = 1000000007;

        for(int i = 0 ; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

           left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty() ? arr.length - i : stack.peek() - i;

            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < arr.length; i++){
            long contri = (long) left[i] * right[i] * arr[i];

            sum = (sum + contri) % mod;
        }

        return (int)sum;
    }
}
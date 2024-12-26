// Approch - 2, I literally dont understand the approch using stack, hoe this sub arrays are forming and how we are calculating
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        int MOD = 1000000007;
        
        for(int i = 0; i <= arr.length; i++){ // this conditio is very tricky, why we use i <= length; we can because there is other condition **
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])){ // **here i == length, which is true and then it directly enters in the while loop, it wont go and check fo arr[i];
                int minIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                long count = ((minIndex - leftIndex) * (rightIndex - minIndex)) % MOD;

                sum += count * arr[minIndex];
                sum %= MOD;
            }
            stack.push(i);
        }
        return (int)(sum);
    }
}

// Approch - 1 (self), brute force, start making sub arrays and find the minimum, add that into ans and return it, TC - O(n2) because we hve to run a loop for n elements, for n times.
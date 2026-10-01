class Solution {
    public long subArrayRanges(int[] nums) {
        return subMax(nums) - subMin(nums);
    }

    private long subMax(int[] nums){
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;

            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < n; i++){
            long temp = (long) left[i] * right[i] * nums[i];
            sum = sum + temp;
        }

        return sum;
    }

    private long subMin(int[] nums){
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;

            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < n; i++){
            long temp = (long) left[i] * right[i] * nums[i];
            sum = sum + temp;
        }

        return sum;
    }
}
// Approch - 2, monotonic stack,
class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for(int i = 0; i <= nums.length; i++){
            // we are finding the subarrays with the current element minimum;   
            while (!stack.isEmpty() && (i == nums.length || nums[i] <= nums[stack.peek()])){
                int mid = stack.pop();
                int leftBound = stack.isEmpty() ?  -1 : stack.peek();
                int rightBound = i;
                ans -= (long) nums[mid] * (mid - leftBound) * (rightBound - mid);
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i <= nums.length; i++){
            // we are finding the subarrays with the current element maximum;   
            while (!stack.isEmpty() && (i == nums.length || nums[i] >= nums[stack.peek()])){
                int mid = stack.pop();
                int leftBound = stack.isEmpty() ?  -1 : stack.peek();
                int rightBound = i;
                ans += (long) nums[mid] * (mid - leftBound) * (rightBound - mid);
            }
            stack.push(i);
        }
        return ans;
    }
}

// Approch - 1(self), brute force, one pointer from left and other from right, TC O(n2);
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 2 * n - 1; i >= 0 ; i--){
            int num = nums[i % n];

            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i % n] = stack.peek();
            }

            stack.push(num);
        }
        return ans;
    }
}
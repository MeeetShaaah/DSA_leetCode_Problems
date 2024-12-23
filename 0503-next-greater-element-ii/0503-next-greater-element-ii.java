// I dont know how is it working,
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int n = nums.length;
        Arrays.fill(result,-1);

        for (int i = 2*n - 1; i >= 0; i--){
            int currentIndex = i%n;
            while (!stack.isEmpty() && nums[currentIndex] >= stack.peek()){
                stack.pop();
            }

            if(i < n){
                if(stack.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = stack.peek();
                }
            }

            stack.push(nums[currentIndex]);
        }
        return result;
    }
}
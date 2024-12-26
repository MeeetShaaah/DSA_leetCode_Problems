// Approch - 1(self), for every indices we calculate the minimum for subarrays and then we calculate the area add to the max
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i == n || heights[i] <= heights[stack.peek()])){
                int height = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                int width = rightIndex - leftIndex - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
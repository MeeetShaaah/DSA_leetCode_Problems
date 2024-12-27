// The solution treats each row of the matrix as a histogram, updating a heights array to track column heights. For each row, the height increases for '1's and resets to zero for '0's. After updating the array, the largest rectangle is calculated using a stack-based histogram algorithm. This process repeats for each row, ensuring the maximum rectangle of '1's is found efficiently.

class Solution {
    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0) return 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] heights = new int[columns];  
        int maxArea = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                heights[j] = matrix[i][j] == '1' ? ++heights[j] : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }  
        return maxArea;
    }
}
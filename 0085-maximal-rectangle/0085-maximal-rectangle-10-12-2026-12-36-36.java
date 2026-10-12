class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix[0].length == 0) return 0;

        int max = 0;
        int col = matrix[0].length;

        int[] height = new int[col];

        for(int i = 0; i < matrix.length; i++){
    
            for( int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }        
            }

            max = Math.max(max, histogram(height));
        }

        return max;
    }

    private int histogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
}
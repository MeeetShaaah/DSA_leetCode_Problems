// Approach 1 - O(mlogn) - with binary search, traverse through every row, call helper function in every row to check the element


// Approach 2 - O(m + n), 2 pointer 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0){
            
            if(matrix[row][col] == target){
                return true;
            }

            if(matrix[row][col] > target){
                col--;
            }else{
                row ++;
            }
        }
        return false;
    }
}
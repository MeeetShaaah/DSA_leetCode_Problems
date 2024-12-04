// Approch - 2, by observing we can see that, every rows and columns in result matrix can be obtain by, 1) transform the matrix (colums to rows to columns) and, 2) reverse the row which rotate the original matrix to 90 degree clockwise,

class Solution {
    public void rotate(int[][] matrix) {
        //Step -1, transform the matrix
        for (int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step - 2, after transform, reverse the rows only;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

// Approch - 1, Brute Force, traverse to the every element of the matrix and then update the element with math function. 
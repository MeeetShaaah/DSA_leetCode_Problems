class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int maxRow = 0;
            for (int i = 1; i < mat.length; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int leftValue = (mid == 0) ? -1 : mat[maxRow][mid - 1];
            int rightValue = (mid == mat[0].length - 1)
                    ? -1
                    : mat[maxRow][mid + 1];

            if (mat[maxRow][mid] > leftValue &&
                mat[maxRow][mid] > rightValue) {
                return new int[]{maxRow, mid};
            }

            if (leftValue > mat[maxRow][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] { -1, -1};
    }
}
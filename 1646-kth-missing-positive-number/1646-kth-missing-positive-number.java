class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 1, high = arr[arr.length - 1] + k;

        // Binary search for the kth missing number
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Count missing numbers <= mid
            int missingCount = countMissingNumbers(arr, mid);

            if (missingCount < k) {
                // If missing numbers are less than k, we need to look for a larger value
                low = mid + 1;
            } else {
                // If missing numbers are >= k, try for a smaller number
                high = mid - 1;
            }
        }

        // After the loop, low will point to the kth missing number
        return low;
    }

    private int countMissingNumbers(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num <= x) {
                count++;
            }
        }
        // Missing numbers up to x is the difference between x and the count of numbers <= x
        return x - count;
    }
}

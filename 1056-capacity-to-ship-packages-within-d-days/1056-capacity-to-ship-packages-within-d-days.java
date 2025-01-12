// used GPT, ltraicky question, go thriugh this again and solve this
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // Find the range for the binary search: 
        // Low is the max weight of a single package.
        // High is the total sum of the weights.
        for (int weight : weights) {
            low = Math.max(low, weight); // max of a single package
            high += weight; // sum of all package weights
        }

        // Binary search to find the minimum ship capacity
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShipInDays(weights, mid, days)) {
                high = mid; // Try a smaller capacity
            } else {
                low = mid + 1; // Increase the capacity
            }
        }

        return low;
    }

    // Helper function to check if it's possible to ship all packages within `days` days with a given capacity `capacity`
    private boolean canShipInDays(int[] weights, int capacity, int days) {
        int currentWeight = 0;
        int dayCount = 1; // Start counting days from day 1

        for (int weight : weights) {
            currentWeight += weight;

            if (currentWeight > capacity) {
                // If the current weight exceeds capacity, move to the next day
                dayCount++;
                currentWeight = weight; // Start new day with the current package

                if (dayCount > days) {
                    return false; // Exceeds the number of allowed days
                }
            }
        }

        return true; // Can ship within the given days
    }
}

// saw the solution I am not gettig this how this guys are solving the problem 

class Solution {
    // Helper function to check if it's possible to make 'requiredBouquets' with 'flowersPerBouquet'
    // by day 'maxDay'.
    public static boolean canMakeBouquets(int[] bloomDays, int maxDay, int requiredBouquets, int flowersPerBouquet) {
        int flowerCount = 0; // Count of consecutive bloomed flowers.
        int bouquetCount = 0; // Count of bouquets made.

        for (int bloomDay : bloomDays) {
            if (bloomDay <= maxDay) {
                flowerCount++;
                // If enough flowers for one bouquet are collected:
                if (flowerCount == flowersPerBouquet) {
                    bouquetCount++;
                    flowerCount = 0; // Reset flower count for the next bouquet.
                }
            } else {
                flowerCount = 0; // Reset count if flower hasn't bloomed by maxDay.
            }
        }

        return bouquetCount >= requiredBouquets; // Check if enough bouquets can be made.
    }

    public int minDays(int[] bloomDays, int requiredBouquets ,int flowersPerBouquet) {
        long totalRequiredFlowers = (long) requiredBouquets * flowersPerBouquet;
        int totalFlowers = bloomDays.length;

        // If total flowers needed exceed the available flowers, it's impossible.
        if (totalRequiredFlowers > totalFlowers) return -1;

        // Find the range of days (minDay to maxDay).
        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for (int bloomDay : bloomDays) {
            minDay = Math.min(minDay, bloomDay);
            maxDay = Math.max(maxDay, bloomDay);
        }

        // Binary search to find the minimum day.
        int low = minDay, high = maxDay;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (canMakeBouquets(bloomDays, mid, requiredBouquets, flowersPerBouquet)) {
                high = mid - 1; // Try to find an earlier day.
            } else {
                low = mid + 1; // Increase the days.
            }
        }

        return low;
    }
}
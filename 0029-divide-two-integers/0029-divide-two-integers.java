class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle simple case
        if (dividend == divisor) return 1;

        // Determine the sign of the result
        boolean sign = (dividend >= 0) == (divisor > 0);

        // Convert to long to avoid overflow during abs
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        // Perform division using bitwise shifts
        while (n >= d) {
            int counter = 0;
            while (n >= (d << (counter + 1))) {
                counter++;
            }
            ans += 1 << counter;
            n -= d << counter;
        }

        // Apply the sign
        ans = sign ? ans : -ans;

        // Return clamped result within 32-bit integer range
        return ans;
    }
}

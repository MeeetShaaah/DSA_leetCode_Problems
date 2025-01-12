class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);

        while(low <= high){
            int mid = (low + high) / 2;
            int sum = findSumWith(nums, mid);

            if( sum <= threshold){ //In this scenario, when the sum exceeds the threshold, it indicates that the current divisor is too small, resulting in a sum greater than the allowed threshold. To reduce the sum, we need to increase the divisor. Since the binary search is used to find the appropriate divisor, we adjust the search range accordingly. If the sum is higher than the threshold, it suggests that the divisor needs to be increased, which is why we update the search bounds by moving the lower bound (low = mid + 1). This ensures that we are progressively testing larger divisors to reduce the sum to an acceptable level.
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private int findSumWith(int[] nums, int divisor){
        int sum  = 0;

        for (int i = 0; i < nums.length; i++){
            sum += Math.ceil((double)(nums[i]) / (double)(divisor));
        }
        return sum;
    }

    private int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
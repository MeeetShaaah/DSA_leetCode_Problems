// Approch - 1(self), for every subarray if we count only zeros and if the zeros are more then k then break and move to the next index, because we can only flip the zeros and if we flip k number of zero the total sub array size will be the max. 

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;

        for (int start = 0; start < nums.length; start++) {
            int zeroCount = 0;
            
            // Check every subarray starting from 'start'
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroCount++;
                }

                // If we exceed k zeros, break the loop
                if (zeroCount > k) {
                    break;
                }

                // Update the maximum length
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}

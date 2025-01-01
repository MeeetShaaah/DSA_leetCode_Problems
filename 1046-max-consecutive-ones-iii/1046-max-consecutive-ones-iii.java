// Approch - 2, I have to optimize the solution to O(n) TC, how?? use sliding window, now the question is, how to use sliding window....how to work with it?

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int max = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
        max = Math.max(max, right - left + 1);

        right++;
        }
        return max;
    }
}

// Approch - 1(self), for every subarray if we count only zeros and if the zeros
// are more then k then break and move to the next index, because we can only
// flip the zeros and if we flip k number of zero the total sub array size will
// be the max. Tc - O(n2)

// class Solution {
// public int longestOnes(int[] nums, int k) {
// int maxLength = 0;

// for (int start = 0; start < nums.length; start++) {
// int zeroCount = 0;

// // Check every subarray starting from 'start'
// for (int end = start; end < nums.length; end++) {
// if (nums[end] == 0) {
// zeroCount++;
// }

// // If we exceed k zeros, break the loop
// if (zeroCount > k) {
// break;
// }

// // Update the maximum length
// maxLength = Math.max(maxLength, end - start + 1);
// }
// }

// return maxLength;
// }
// }

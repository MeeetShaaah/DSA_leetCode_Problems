// Same as 2nd approch, but the implementation style is differnet..
class Solution {
    public int maxSubArray(int[] nums) {
      int sum = 0;
      int max = Integer.MIN_VALUE;

      for (int num : nums){
        sum = Math.max(sum + num, num);
        max = Math.max(max, sum);
      }  
      return max;
    }
}


// Approch - 2, known as Kadane's Algorithm, very it is just a math
// class Solution {
//     public int maxSubArray(int[] nums) {

//         int sum = 0;
//         int max = Integer.MIN_VALUE;

//         for (int num : nums){
//             sum += num;

//             if (sum > max) max = sum;

//             if (sum < 0) sum = 0;
//         }
//         return max;
//     }
// }

// Approch - 1, brute force, 2 for loops, 1st to pick the element and 2nd to calculate the sum and then Math.max
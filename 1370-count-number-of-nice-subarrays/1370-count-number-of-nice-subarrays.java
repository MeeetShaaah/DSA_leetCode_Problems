// I have to learn how to use prefix sum and hashmap, I am not getting how this approch works.
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int currentSum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i] % 2;

            if(map.containsKey(currentSum - k)){
                result += map.get(currentSum - k);
            }

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}

// Approch - self, for this (return atMost(nums, k) - atMost(nums, k-1);) i saw the solution

// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         return atMost(nums, k) - atMost(nums, k-1);
//     }

//     private int atMost(int[] nums, int k){
//         int left = 0;
//         int right = 0;
//         int count = 0;

//         while (right < nums.length){
//             if(nums[right] % 2 != 0){
//                 k--;
//             }

//             while (k < 0){
//                 if(nums[left] % 2 != 0){
//                     k++;
//                 }
//                 left++;
//             }

//             count += right - left + 1;
//             right++;
//         }
//         return count; 
//     }
// }
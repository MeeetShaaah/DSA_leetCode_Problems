// Approach - 2, 
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;

        if(nums1.length % 2 !=0){
            for(int num : nums2){
                ans ^= num;
            }
        } 

        if(nums2.length % 2 !=0){
            for(int num : nums1){
                ans ^= num;
            }
        }         
        return ans;
    }
}

// Approach - 1(self), for every element from nums1 we do bitwise xor operation with every elements of nums2, tc will be O(n2). definetely not acceptable approach
// class Solution {
//     public int xorAllNums(int[] nums1, int[] nums2) {
//         int ans = 0;

//         for (int i = 0; i < nums1.length; i++){
//             for(int j = 0; j < nums2.length; j++){
//                 ans = ans ^ (nums1[i] ^ nums2[j]);
//             }
//         }
//         return ans;
//     }
// }

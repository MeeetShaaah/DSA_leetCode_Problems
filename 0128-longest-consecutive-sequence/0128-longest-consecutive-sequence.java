//Approch - 2, Using set, which take off the duplicates and then we 
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for (int num : nums){
            set.add(num);
        }

        for (int element : set){
            if (!set.contains(element - 1)){
                int count = 1;

                int x = element;
                while (set.contains(x + 1)){
                    count ++;
                    x = x+1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
// Approch - 1, sort the array and apply the logic, TC - O(nlogn) so i have to improve this to O(n)...!! 
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Arrays.sort(nums);

//         if (nums.length == 0) return 0;

//         int count = 1; 
//         int max = 1;

//         for (int i = 1; i < nums.length; i++){
//             if (nums[i] == nums[i-1]) continue;

//             if(nums[i] - nums[i-1] == 1){
//                 count ++;
//             } else {
//                 max = Math.max(max, count);
//                 count = 1;
//             }
//         }
        
//         return Math.max(count, max);
//     }
// }
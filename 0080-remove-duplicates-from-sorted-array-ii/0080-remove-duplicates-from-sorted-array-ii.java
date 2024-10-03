class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0) return 0;
        
        int slow = 1; // start the slow pointer from the second element
        int count = 1; // track how many times the current element has appeared
        
        for (int fast = 1; fast < nums.length; fast++) {
            // If the current element (nums[fast]) is the same as the previous one
            if (nums[fast] == nums[fast - 1]) {
                count++;
            } else {
                // Reset count to 1 if we encounter a new element
                count = 1;
            }
            
            // If the count is <= 2, keep the element
            if (count <= 2) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }
}
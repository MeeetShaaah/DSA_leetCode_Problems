class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 1) return 1; 
        int slow = 1; //this changes the array itself (nums)

        for(int fast = 1; fast < nums.length; fast ++){
            if (nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
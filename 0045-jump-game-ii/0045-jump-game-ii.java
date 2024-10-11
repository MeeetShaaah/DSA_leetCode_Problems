class Solution {
    public int jump(int[] nums) {
        int reach = nums[0];
        int maxReach = nums[0];
        int count = 1;
        if(nums.length <= 2) return nums.length-1;

        for(int i = 1; i< nums.length-1; i++){

            maxReach = Math.max(maxReach, nums[i] + i);

            if(i == reach){
                reach = maxReach;
                count++;
            }
        }
        return count;
    }
}
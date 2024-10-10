class Solution {
    public boolean canJump(int[] nums) {
        int reach = nums[0];

        if (nums.length == 1) return true;

        for (int i = 1; reach>=i; i++){
            if(reach>=nums.length -1){
                return true;
            }

            reach = Math.max(reach, nums[i]+i);
        }
        return false;
    }
}
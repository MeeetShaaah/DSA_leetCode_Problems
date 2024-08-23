class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] diffarry = new int[n];
        int sumright = Arrays.stream(nums).sum();
        int sumleft = 0;

        for(int i=0; i<n; i++)
        {
            sumright = sumright - nums[i];
            diffarry[i] = Math.abs(sumleft - sumright);
            sumleft = sumleft + nums[i];
        }   
    return diffarry;
    }
}
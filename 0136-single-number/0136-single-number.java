class Solution {
    public int singleNumber(int[] nums) {
        int xOR = 0;
        for (int num : nums){
            xOR ^= num;
        }
        return xOR;
    }
}
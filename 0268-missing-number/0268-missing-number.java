class Solution {
    public int missingNumber(int[] nums) {
        int number = nums.length;

        int s1 = number *(number+1)/2;

        int s2 = 0;

        for (int i : nums){
            s2 += i;
        }

        return s1-s2;
    }
}
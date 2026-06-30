// prefix Sum, 
class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = nums[0];

        // if(nums.length == 1){
        //     return nums[0];
        // }

        while(j < nums.length){
            
            sum += nums[j]; 
            
            max = Math.max(max, sum);
            while(sum < 0 && i <= j){
                sum -= nums[i];
                i++;
            }

            j++;
        }
        return max;
    }
}
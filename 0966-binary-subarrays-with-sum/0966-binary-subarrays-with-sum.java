class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, right = 0;
        int totalCount = 0;
        int currentSum = 0;
        int countZero = 0;
        
        while(right < nums.length){
            currentSum += nums[right];

            while(left < right && (nums[left] == 0 || currentSum > goal)){
                if(nums[left] == 1){
                    countZero = 0;
                } else countZero++;
                
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == goal){
                totalCount += 1 + countZero;
            }

            right++;
        }
        return totalCount;
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;

        if(target < nums[0]){
            return answer;
        }
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                right = mid - 1;
            }else{
                answer = mid;
                left = mid + 1;
            }
        }
        return answer + 1;
    }
}
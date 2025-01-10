// this one is super easy, just take care of edge cases, what if this (nums[left] == nums[mid] && nums[mid] == nums[right]) is satisfied, 

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left = left + 1;
                right = right - 1;
                continue;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }   
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            } 
        }
        return false;
    }
}
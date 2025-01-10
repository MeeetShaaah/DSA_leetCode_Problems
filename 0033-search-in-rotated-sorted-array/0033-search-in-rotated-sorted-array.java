// My approach was on the right track, but I still needed to refer to the solution.
// The condition if (nums[left] <= nums[mid]) is used to determine which half of the array is sorted. In a rotated sorted array, at least one half (either left or right) of the array is always sorted.

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid]== target){
                return mid;
            }
            
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
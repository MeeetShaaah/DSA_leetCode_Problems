//Approach - 2, You forgot that you can also use xOR (Shame...)
//Approach - 1, linear search, and compare the elements,
//Approach - 3, binary serach, go through this solution (not getting this ** part)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; 

        if(n == 1){
            return nums[0];
        }else if(nums[0]!=nums[1]){
            return nums[0];
        }else if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        int left = 0;
        int right = n - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            // ** i am not geting this conditions...
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
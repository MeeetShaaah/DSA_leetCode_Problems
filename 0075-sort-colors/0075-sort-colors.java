class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(mid <= right){
            if (nums[mid] > 1){
                int temp = nums[mid] ;
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }else if(nums[mid] < 1){
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                mid++;
                left++;
            }else{
                mid++;
            }
        }
    }
}
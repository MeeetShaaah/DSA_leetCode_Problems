class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);

        return result;
    }

    private int findStartingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int start = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                start = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return start;
    }

    private int findEndingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int end = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                end = mid;
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return end;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);

        return new int[] { first, last };
    }

    public int firstOccurance(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                answer = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }

    public int lastOccurance(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                answer = mid;
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}
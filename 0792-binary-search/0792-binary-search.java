class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return findTarget(nums, target, left, right);
    }

    private int findTarget(int[] nums, int target, int left, int right){
        if(left > right) return -1;

        int mid = left + (right - left)/2;
        
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return findTarget(nums, target, mid + 1, right);
        }else {
            return findTarget(nums, target, left, mid - 1);
        }
        // return -1;
    }
}

// this is the iterative apporach, 
// class Solution {
//     public int search(int[] nums, int target) {
//         int left = 0;
//         int right = nums.length - 1;

//         while(left <= right){
//             int mid = left + (right - left)/2;

//             if(nums[mid] == target){
//                 return mid;
//             }else if(nums[mid] < target){
//                 left = mid + 1;
//             }else {
//                 right = mid - 1;
//             }
//         }
//         return -1;
//     }
// }
// didt do it by my self, saw the solution and rewrite the code, 
// Step - 1, find the break point (when, traversing from tail, i+1 > i, called breakPoint)
// Step - 2, check the breakPoint == -1, means the whole array is in descending order, simply reverse and it will be the next permutation
// Step - 3, if find the breakPoint then, find the element which is larger then the breakPoint but that element is smallest larger from tail,
// Step - 4, reverse the right part from breakPoint.

class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;

        for (int i = nums.length -2; i >= 0; i--){
            if (nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1){
            reverse(nums, 0, nums.length -1);
            return; 
        }

        for (int i = nums.length - 1; i > breakPoint; i--){
            if (nums[breakPoint] < nums[i]){
                int temp = nums[breakPoint];
                nums[breakPoint] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, breakPoint + 1, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end--;
        }
    }
}
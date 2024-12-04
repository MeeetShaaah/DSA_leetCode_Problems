class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;

        for (int i = nums.length - 2; i >= 0; i--){
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
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }

        reverse(nums, breakPoint + 1, nums.length -1);
    }

    private void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
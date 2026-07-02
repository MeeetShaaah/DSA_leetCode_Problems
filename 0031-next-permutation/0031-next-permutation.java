class Solution {
    public void nextPermutation(int[] nums) {

        int j = nums.length - 1;
        int marker = -1;

        while(j > 0){
            if(nums[j] > nums[j-1]){
                marker = j-1;
                break;
            }
            j--;
        }      

        for(int i = nums.length - 1; i > marker; i--){
            if((marker != -1) && (nums[i] > nums[marker])){
                int temp = nums[i];
                nums[i] = nums[marker];
                nums[marker] = temp;
                break;
            }
        }  

        int m = marker + 1;
        int n = nums.length - 1;

        while (m < n){
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;

            m++;
            n--;
        }
    }
}

// [1,2,3]
// 1, 3, 2
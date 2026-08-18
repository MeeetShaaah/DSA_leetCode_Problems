class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;

        for(int num : nums){
            max = Math.max(num, max);
            sum += num;
        }

        long left =  max;
        long right = sum;

        while (left <= right){
            long mid = left + (right - left) / 2;

            if(countSubarraySum(nums, mid) <= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public long countSubarraySum(int[] nums, long maxSum){
        long count = 1;
        long sum = 0;

        for(int num : nums){
            if(sum + num > maxSum){
                count++;
                sum = num;
            }else{
                sum += num;
            }
        }
        return count;
    }
}
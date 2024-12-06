// Approch - 2, prefix an suffix profuct, but the issue is when zero comes, so we have to again change the value of that varibles....!!!
class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1;
        int suf = 1;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;

            pre *= nums[i];
            suf *= nums[nums.length - i -1];

            ans = Math.max(ans, Math.max(pre, suf)); 
        }
        return ans;
    }
}

// Approch - 1, Brute Force approch, pich one element using for loop and multiple it, with another loop, check max after 2nd loop, do this process n times, and again check for mx before execting the 2nd loop.
class Solution {
    public int subtractProductAndSum(int n) {
        int product= 1;
        int sum= 0;
        int result =0;
        for (int temp=n; temp>0; temp/=10){
            int digit = temp%10;
            product *= digit;
            sum +=digit;
        }
        return product-sum;
    }
}
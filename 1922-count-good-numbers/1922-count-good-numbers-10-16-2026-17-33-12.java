class Solution {
    final long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long evenCount = n - n / 2;
        long oddCount = n / 2;

        long result = pow(5 , evenCount) * pow(4, oddCount) % mod;

        return (int)result;
    }

    private long pow(int n, long count){
        if(count == 0) return 1;

        long half = pow(n, count / 2);

        long result = half * half % mod;

        if(count % 2 == 1){
            result = result * n % mod;
        }

        return result;
    }
}
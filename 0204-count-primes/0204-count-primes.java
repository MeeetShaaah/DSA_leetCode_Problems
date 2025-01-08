// didnt do this by self, this is the unique method to find the prime numbers or prime counts,
// see the video from striver's list step: 8; lec: 3; "Print Prime Factors of a Number" (very useful, learn all methods to find the prime number)
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;

        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for(int  i = 2; i * i < n; i++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}
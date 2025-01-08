class Solution {
    public int minBitFlips(int start, int goal) {
       int ans = start ^ goal;
       int counter = 0;

       while (ans > 1){
        counter += ans&1;

        ans = ans >> 1;
       }

       if(ans == 1) counter++;

       return counter;
    }
}
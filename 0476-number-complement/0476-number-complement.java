class Solution {
    public int findComplement(int num) {
       int mask =0;
       int m=num;

       if (num == 0){
        return 1;
       }

       while (m!=0){
        mask = (mask<<1)|1;
        m>>=1;
       } 
       return mask & (~num);
    }
}
class Solution {
    public int bitwiseComplement(int n) {
      int mask = 0;
      int m = n;
      if (n==0){
        return 1;
      }
      while (m!=0){
        mask = (mask<<1) | 1;
        m>>=1;
      }  
      return mask & (~n);
    }
}
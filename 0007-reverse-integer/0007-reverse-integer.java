class Solution {
    public int reverse(int x) {
        int New_Number = 0;

        while (x !=0)
        {
            int digit = x % 10;
            if ((New_Number < Integer.MIN_VALUE/10) || (New_Number > Integer.MAX_VALUE/10))
            {
                return 0;
            }
            
            New_Number = (New_Number * 10) + digit;
            x = x / 10;
        }
        return New_Number;
    }
}
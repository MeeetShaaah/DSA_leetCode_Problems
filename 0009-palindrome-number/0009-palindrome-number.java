class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int temp = x;

        if (x < 0) return false;
        
        while (temp !=0){
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp = temp/10;
        }
        return(reverse == x);
    }
}
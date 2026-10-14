class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        boolean neg = false;
        if(exp < 0) neg = true;

        if(exp < 0){
            exp = -exp;
        }

        double result = 1.0;

        while(exp > 0){
            if(exp % 2 == 1){
                result *= x;
            }

            x *= x;
            exp /= 2;
        }

        return neg ? 1 / result : result;
    }
}
class Solution {
    public double myPow(double x, int n) {
        int exp = n;
        boolean neg = false;

        if(exp < 0){
            neg = true;
            exp = -exp;
        }
    
        double result = pow(x, exp);

    return neg ? 1 / result : result;
    }

    private double pow(double x, int exp){
        if (exp == 0) return 1.0;

        double half = pow(x, exp / 2);
        
        if(exp % 2 == 0){
            return half * half;
        }else{
            return x * half * half;
        }
    }
}

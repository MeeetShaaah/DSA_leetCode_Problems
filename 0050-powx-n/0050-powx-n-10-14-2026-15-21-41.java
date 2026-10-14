// class Solution {
//     public double myPow(double x, int n) {
//         long exp = n;

//         if(exp < 0){
//             x = 1 / x;
//             exp = -exp;
//         }

//         return pow(x, exp);
//     }

//     private doublw pow(double x, int exp){

//     }
// }

class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        boolean negative = exp < 0;
        if (negative) exp = -exp;

        double result = 1.0;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= x;
            }
            x *= x;
            exp /= 2;
        }

        return negative ? 1.0 / result : result;
    }
}
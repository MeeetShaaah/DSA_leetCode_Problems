// Approch - 2, just check from back side and the 1st odd numbet from back side gives the largest odd value from given string, didnt come this solution in my mind because i didnt know about .substring() method....!!!!!
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >=0; i--){
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}

// Approch - 1, initiated with this approch, convert the num to num char array, start traversing from the 0th index, divide the number by 2 and append that into substring. leanthy approch
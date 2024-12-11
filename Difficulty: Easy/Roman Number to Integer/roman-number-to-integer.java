//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    static Map<String, Integer> romanValues = new HashMap<>();
    static {
        romanValues.put("M", 1000);
        romanValues.put("D", 500);
        romanValues.put("C", 100);
        romanValues.put("L", 50);
        romanValues.put("X", 10);
        romanValues.put("V", 5);
        romanValues.put("I", 1);
    }
    
    public int romanToDecimal(String s) {
        // code here
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = romanValues.get(lastSymbol);
        int total = lastValue;

        for(int i = s.length() - 2; i >= 0; i--){
            String currentSymbol = s.substring(i, i+1);
            int currentValue = romanValues.get(currentSymbol);
            if(currentValue < lastValue){
                total -= currentValue;
            }else total += currentValue;

            lastValue = currentValue;
        }    
        return total;
    }
}
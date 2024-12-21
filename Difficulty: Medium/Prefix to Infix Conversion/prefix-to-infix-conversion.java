//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        
        for (int i = pre_exp.length() - 1; i >= 0; i--){
            
            char c = pre_exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)){
                stack.push(Character.toString(c));
            }
            
            else{
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                String expression = "(" + operand1 + c + operand2 + ")";
                
                stack.push(expression);
            }
            
        }
        
        return stack.pop();
    }
}

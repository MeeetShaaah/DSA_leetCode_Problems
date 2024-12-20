//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int precedence(char operator){
        switch (operator){
            
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
            
            case '^':
                return 3;
            
            default:
                return -1;
        }    
    }
    
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (Character.isLetterOrDigit(c)){
                result.append(c);
            }
            
            else if(c == '('){
                stack.push(c);
            }
            
            else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
            
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
            
        }
        
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
}
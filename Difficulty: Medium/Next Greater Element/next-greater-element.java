//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(arr.length);
        
        for (int i = 0; i < arr.length; i++){
            result.add(-1);
        }
        
        for (int i = arr.length - 1; i >=0; i--){
            while (!stack.isEmpty()  && arr[i] >= stack.peek()){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                result.set(i, stack.peek());
            }
            
            stack.push(arr[i]);
        }
        
        return result;
    }
}


// Approch - 1, TLA, becuase I am converting the array to arrayList so... instead directly use arrayList..

//  class Solution {
//     // Function to find the next greater element for each element of the array.
//     public ArrayList<Integer> nextLargerElement(int[] arr) {
//         // code here
//         Stack<Integer> stack = new Stack<>();
//         int[] result = new int[arr.length];
        
//         for (int i = arr.length - 1; i >=0; i--){
//             while (!stack.isEmpty()  && arr[i] >= stack.peek()){
//                 stack.pop();
//             }
            
//             if(stack.isEmpty()){
//                 result[i] = -1;
//             }else {
//                 result[i] = stack.peek();
//             }
            
//             stack.push(arr[i]);
//         }
        
//         ArrayList<Integer> newResult = new ArrayList<>();
        
//         for (int i = 0 ; i < result.length; i++){
//             newResult.add(result[i]);
//         }
        
//         return newResult;
//     }
// }
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            int[] a = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            Solution ob = new Solution();
            ob.segregateElements(a);
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            T--;
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        Stack<Integer> neg = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        
        for (int i = 0; i< arr.length; i++ ){
            if (arr[i] < 0){
                neg.push(arr[i]);
            }else pos.push(arr[i]);
        }
        
        int n = arr.length - 1;
        
        while (!neg.isEmpty()){
            arr[n] = neg.pop();
            n--;
        } 
        
        while (!pos.isEmpty()){
            arr[n] = pos.pop();
            n--;
        }
    }
}
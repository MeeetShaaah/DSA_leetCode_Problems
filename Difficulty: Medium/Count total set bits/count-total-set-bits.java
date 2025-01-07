//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    // Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n) {
        int count = 0;
        int i = 0;
        
        // Iterate while 2^i is less than or equal to n
        while ((1 << i) <= n) {
            // Calculate total pairs of 0s and 1s in blocks of size 2^(i+1)
            boolean isOdd = ((n >> i) & 1) == 1;
            
            count += (n >> (i + 1)) * (1 << i);
            if (isOdd) count += (n & ((1 << i) - 1)) + 1;
            
            i++;
        }
        
        return count;
    }
}


//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		
System.out.println("~");
}
	}
}

// } Driver Code Ends
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
// Go through this question again, ...

class Solution
{
    public int[] twoOddNum(int arr[], int N){
        
    int xorAll = 0;
        
        // Step 1: XOR all elements
        for (int num : arr) {
            xorAll ^= num;
        }
        
        // Step 2: Find the rightmost set bit
        int setBit = xorAll & -xorAll;
        
        int x = 0, y = 0;
        
        // Step 3: Divide into two groups and XOR separately
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;  // Group 1: Bit is set
            } else {
                y ^= num;  // Group 2: Bit is not set
            }
        }
        
        // Step 4: Return in decreasing order
        if (x > y) {
            return new int[]{x, y};
        } else {
            return new int[]{y, x};
        }
    }
}
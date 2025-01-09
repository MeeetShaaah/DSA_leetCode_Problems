//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

// linear search 
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor = -1;
        int ceil = -1;
        
        // Traverse the entire array
        for (int num : arr) {
            // Update floor if num <= x and num is greater than the current floor
            if (num <= x && (floor == -1 || num > floor)) {
                floor = num;
            }
            // Update ceil if num >= x and num is smaller than the current ceil
            if (num >= x && (ceil == -1 || num < ceil)) {
                ceil = num;
            }
        }
        
        return new int[] {floor, ceil};
    }
}
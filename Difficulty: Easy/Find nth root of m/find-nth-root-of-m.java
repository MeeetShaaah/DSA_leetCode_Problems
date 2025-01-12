//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int l = 1;
        int r = m;

        while (l <= r) {
            int mid = (l + r) / 2;

            long power = fastPower(mid, n); // Compute mid^n

            if (power == m) {
                return mid; // Found the nth root
            } else if (power > m) {
                r = mid - 1; // Reduce the search space
            } else {
                l = mid + 1; // Increase the search space
            }
        }

        return -1; // No integer nth root exists
    }

    // Helper function to calculate base^exp using fast exponentiation
    private long fastPower(int base, int exp) {
        long result = 1;
        long currentBase = base;

        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result *= currentBase;
            }
            currentBase *= currentBase; // Square the base
            exp >>= 1; // Divide exp by 2
        }

        return result;
    }
}
//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// Do this again....(logic)
class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        // Step 1: Check for divisibility by 2
        if (N % 2 == 0) {
            primeFactors.add(2); // 2 is a prime factor
            while (N % 2 == 0) {
                N /= 2;  // Divide N by 2 until it's no longer divisible by 2
            }
        }

        // Step 2: Check for divisibility by odd numbers (3, 5, 7, ...)
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            if (N % i == 0) {
                primeFactors.add(i); // i is a prime factor
                while (N % i == 0) {
                    N /= i;  // Divide N by i until it's no longer divisible by i
                }
            }
        }

        // Step 3: If N is still greater than 2, it must be a prime
        if (N > 2) {
            primeFactors.add(N); // N is a prime factor
        }

        // Convert ArrayList to int[] and return
        int[] result = new int[primeFactors.size()];
        for (int i = 0; i < primeFactors.size(); i++) {
            result[i] = primeFactors.get(i);
        }

        return result;  // Return the unique prime factors as an int[] array
    }
}
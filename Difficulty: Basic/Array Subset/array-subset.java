//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] a = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                a[i] = Integer.parseInt(numsStr[i]);
            }
            line = read.readLine().trim();
            numsStr = line.split(" ");
            int[] b = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                b[i] = Integer.parseInt(numsStr[i]);
            }
            Solution ob = new Solution();
            if (ob.isSubset(a, b))
                System.out.println("Yes");
            else
                System.out.println("No");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i< a.length; i++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
        for(int i = 0; i< b.length; i++){
            if (map.containsKey(b[i])){
                if(map.get(b[i]) == 1){
                    map.remove(b[i]);
                }else {
                    map.put(b[i], map.get(b[i]) - 1);
                }
            }else return false;
        }
        return true;
    }
}

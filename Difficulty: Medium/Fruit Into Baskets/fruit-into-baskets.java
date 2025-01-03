//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        
        if(arr.length == 0) return 0;
        int left = 0;
        int right = 0;
        int length = 0;
        
        Map<Integer, Integer> basket = new HashMap<>();
        
        while(right < arr.length){
            basket.put(arr[right], basket.getOrDefault(arr[right], 0) + 1);    
            
            while(basket.size()>2){
                basket.put(arr[left], basket.get(arr[left]) - 1);
                if(basket.get(arr[left]) == 0){
                    basket.remove(arr[left]);
                }
                left++;
            }
            
            length = Math.max(length, right - left + 1);
            right++;
        } 
        return length;
    }
}
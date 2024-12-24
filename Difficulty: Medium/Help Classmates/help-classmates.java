//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        
System.out.println("~");
}
	} 
} 


// } Driver Code Ends


//User function Template for Java

// Approch, I am directly working with elements, but there is another method as well; you can work with the indices.
class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes her
	    Stack<Integer> stack = new Stack<>();
	    int[] result = new int[n];
	    
	    for(int i = n-1; i >= 0; i--){
	        
	        while(!stack.isEmpty() && stack.peek() >= arr[i]){
	            stack.pop();
	        }
	        
	        if(stack.isEmpty()){
	            result[i] = -1;
	        }else{
	            result[i] = stack.peek();
	        }
	       
	        stack.push(arr[i]);
	    }
	    return result;
	} 
}

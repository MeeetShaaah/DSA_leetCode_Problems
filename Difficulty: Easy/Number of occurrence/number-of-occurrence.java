//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] nums, int target) {
        // code here
        int[] result = new int[2];

        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        
        if (result[0] == -1 || result[1] == -1) {
            return 0;
        }

        return result[1] - result[0] + 1;
    }

    private int findStartingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int start = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                start = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return start;
    }

    private int findEndingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int end = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                end = mid;
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return end;
    }
}
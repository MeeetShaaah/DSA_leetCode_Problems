class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n-k+1];

        for (int i = 0; i < n; i++){
            if (!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if( i >= k-1){
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}

// Approch - 2, easy fix the window first and then move left and right pointer. 
// class Solution {
//     private int findMax(int[] nums, int left, int right){
//         int max = nums[left];
//         for(int i = left; i <= right; i++){
//             max = Math.max(max, nums[i]);
//         }
//         return max;
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {

//         if(nums.length == 0 || k == 0) return new int[0];
        
//         int left = 0, right = 0;
//         int n = nums.length;
//         int[] result = new int[n-k+1];

//         while (right < k-1){
//             right ++;
//         }

//         while (right < n){
//             result[left] = findMax(nums, left, right);
//             left++;
//             right++;
//         }
//         return result;
//     }
// }

// Approch - 1(self), the brute force approch is that, outer loop you can run (n-k) times and the inner loop for ith index to k times, issue is the complexity, TC will be O(n2). check edge cases, if nums.length < k.
// Approch - 3, using two pointers.
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int trappedWater = 0;
        int left_max = 0, right_max = 0;

        while (left < right){
            if (height[left] < height[right]){
                left_max = Math.max(left_max, height[left]);
                trappedWater += left_max - height[left];
                left++;
            }else{
                right_max = Math.max(right_max, height[right]);
                trappedWater += right_max - height[right];
                right--;
            }
        }
        return trappedWater;  
    }
}

// Approch - 2, using stack;
// class Solution {
//     public int trap(int[] height) {
//         Stack<Integer> stack = new Stack<>();
//         int trappedWater = 0;
//         int current = 0;

//         while(current < height.length){
//             while (!stack.isEmpty() && height[current] > height[stack.peek()]){
//                 int top = stack.peek();
//                 stack.pop();
//                 if(stack.isEmpty()) break;
//                 int distance = current - stack.peek() - 1;
//                 int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
//                 trappedWater += distance * boundedHeight;
//             }
//             stack.push(current);
//             current++;
//         }
//         return trappedWater;
//     }
// }

// Approch - 1, for every index, find max and min.
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int trappedWater = 0;
//         for (int i = 0; i < n; i++){
//             int j = i;
//             int leftMax = 0;
//             int rightMax = 0;

//             while (j >= 0){
//                 leftMax = Math.max(leftMax, height[j]);
//                 j--;
//             }

//             j = i;

//             while (j < n){
//                 rightMax = Math.max(rightMax, height[j]);
//                 j++;
//             }

//             trappedWater += Math.min(leftMax, rightMax) - height[i];
//         }

//         return trappedWater;
//     }
// }

// My logic was right but didnt know how to convert into code; The problem is not so hard, the main thing, you have to observe the problem and the testcases, 
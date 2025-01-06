class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int rightMoves = 0; // means, from left to right pass we are moving our balls to right side
        int counter = 0;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[i] = rightMoves;
            
            if (boxes.charAt(i) == '1'){
                counter++;
            }

            rightMoves += counter;
        }

        int leftMoves = 0;
        counter = 0;

        for(int i = n - 1; i >=0; i--){
            ans[i] += leftMoves;
            if (boxes.charAt(i) == '1'){
                counter++;
            }
            leftMoves += counter;
        }
    return ans;
    }
}

// Approch - 1(self), solution with O(n2) TC, need to optimize this.
// class Solution {
//     public int[] minOperations(String boxes) {
//         int n = boxes.length();
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++){
//             ans[i] = findMoves(boxes, i);
//         }
//         return ans;
//     }

//     private int findMoves(String boxes, int i){
//         int moves = 0;
//         for(int j = 0; j < boxes.length(); j++){
//            if(boxes.charAt(j) == '1'){
//             moves += Math.abs(i - j);
//            }
//         }
//         return moves;
//     }
// }
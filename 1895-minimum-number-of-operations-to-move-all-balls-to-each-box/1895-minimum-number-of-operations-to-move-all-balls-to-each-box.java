class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = findMoves(boxes, i);
        }
        return ans;
    }

    private int findMoves(String boxes, int i){
        int moves = 0;
        for(int j = 0; j < boxes.length(); j++){
           if(boxes.charAt(j) == '1'){
            moves += Math.abs(i - j);
           }
        }
        return moves;
    }
}
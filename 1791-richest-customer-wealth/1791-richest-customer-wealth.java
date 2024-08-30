class Solution {
    public int maximumWealth(int[][] accounts) {
       int maxWealth = 0;

       for (int[] customer : accounts){
        int sum=0;
        for (int balance : customer){
            sum+=balance;
        }
        if (sum >= maxWealth){
            maxWealth = sum;
        }
       } 
       return maxWealth;
    }
}
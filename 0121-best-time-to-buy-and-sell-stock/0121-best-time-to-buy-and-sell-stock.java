// Updated Version of my code.
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfite = 0;
        for (int sell = 1; sell < prices.length; sell++){
            if (prices[sell] < buy){
                buy = prices[sell];
            }else if (prices[sell] - buy > maxProfite){
                maxProfite = Math.max(maxProfite, prices[sell] - buy);
            }
        }
        return maxProfite;
    }
}


//  this is my approch, 
// class Solution {
//     public int maxProfit(int[] prices) {
//         int buy = 0;
//         int max = 0;
        
//         for (int sell = 1; sell < prices.length; sell++){
//             if(prices[sell] < prices[buy]){
//                 buy = sell ;
//             }else {
//                 int difference = prices[sell] - prices[buy];
//                 max = Math.max(max, difference);
//             }
//         }
//         return max;
//     }
// }

// Approch - 1, Brute Force using 2 loops. 
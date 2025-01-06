// The question isn't too difficult, but I couldn't solve it on my own. I checked the solution and used GPT for help.
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        int n = cardPoints.length;

        for(int point : cardPoints){
            totalSum += point;
        }

        if(n == k){
            return totalSum;
        }   

        int windowSize = n - k;
        int currentSum = 0;

        for(int i = 0; i < windowSize; i ++){
            currentSum += cardPoints[i];
        }

        int minWindowSum = currentSum;

        for(int i = windowSize; i < n; i++){
            currentSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currentSum);
        }
        return totalSum - minWindowSum;
    }
}
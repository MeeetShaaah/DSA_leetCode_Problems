class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;

        for(int cardPoint : cardPoints){
            totalSum += cardPoint;
        }

        if(cardPoints.length == k){
            return totalSum;
        }

        int windowSize = cardPoints.length - k;
        int currentWindowSum = 0;

        for(int i = 0; i < windowSize; i++){
            currentWindowSum += cardPoints[i];
        }

        int minWindowSum = currentWindowSum;

        for(int i = windowSize; i < cardPoints.length; i++){
            currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }

        return totalSum - minWindowSum;
    }
}
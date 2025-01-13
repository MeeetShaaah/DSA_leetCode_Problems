// my logic was right but still used chatGPT to solve this question.
class Solution {
    private boolean noOfStationsToAdd(int[] stations, double maxDist, int k) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            // Calculate how many stations are needed in this gap
            count += (int) Math.ceil(gap / maxDist) - 1;
        }
        
        if(count > k){
            return true;
        }else{
            return false;
        }
    }

    public double minmaxGasDist(int[] stations, int k) {
        // Sort stations to ensure proper calculation

        double low = 0.0;
        double high = stations[stations.length - 1] - stations[0];
        double precision = 1e-6;

        while (high - low > precision) {
            double mid = (low + high) / 2;

            if (noOfStationsToAdd(stations, mid, k)) {
                // Too many stations needed, increase maxDist
                low = mid; // we are dealing with the pecisions thats why, thing again.
            } else {
                // Fewer or exact stations, try reducing maxDist
                high = mid; // we are dealing with the pecisions thats why, thing again.
            }
        }

        // Either low or high is acceptable since the difference is within precision
        return low;
    }
}

// Approach - 2, implement using binary search; 
class Solution {
    private int findMax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    private int fiindHoursWithCurrentRate(int[] piles, int i){
        int totalHours = 0;

        for (int j = 0; j < piles.length; j++){
            totalHours += Math.ceil((double)(piles[j]) /(double)(i));
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high){
            int mid = (low + high) / 2;
            int hours = fiindHoursWithCurrentRate(piles, mid);

            if(hours <= h){
                high = mid - 1; // this is because, we have to find minimum...think anagin; 
            }else{
                low = mid + 1;
            }
        }
        return low; // this return statement is important....
    }
}

//Approach - 1, Lets start with brute force approach, okay so the question is very simple, in brute force, we first get the max from the array and from 0 to that max we will checck every possiblities, like with the rate of 1,...,max bananas; how much time koko will take....., very tedious task...!!

// class Solution {
//     private int findMax(int[] piles){
//         int maxi = Integer.MIN_VALUE;
//         for(int i = 0; i < piles.length; i++){
//             maxi = Math.max(maxi, piles[i]);
//         }
//         return maxi;
//     }

//     private int fiindHoursWithCurrentRate(int[] piles, int i){
//         int totalHours = 0;

//         for (int j = 0; j < piles.length; j++){
//             totalHours += Math.ceil((double)(piles[j]) /(double)(i));
//         }
//         return totalHours;
//     }

//     public int minEatingSpeed(int[] piles, int h) {
//         int maxi = findMax(piles);

//         for(int i = 1; i <= maxi; i++){
//             int reqiredTime = fiindHoursWithCurrentRate(piles, i);
//             if(reqiredTime <= h){
//                 return i;
//             }
//         }
//         return maxi;
//     }
// }
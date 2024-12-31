/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int i = 0, j = n-1;

        while(i < j){
            if(knows(i,j)){
                i++;
            }else j--;
        }

        int candidate = i;

        for(int k = 0; k < n; k++){
            if(candidate != k){
                if(knows(candidate, k) || !knows(k, candidate)){
                    return -1;
                }
            }
        }
        return candidate;
    }
}
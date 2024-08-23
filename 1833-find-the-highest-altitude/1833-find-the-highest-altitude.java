class Solution {
    public int largestAltitude(int[] gain) {
        int[] newarray = new int[gain.length + 1];
        int highest = 0;
        newarray[0] = 0;
        for (int i=0; i< gain.length; i++){
            newarray[i+1] = newarray[i] + gain[i];
            highest = Math.max(highest, newarray[i+1]);
        }
        return highest;
    }
}
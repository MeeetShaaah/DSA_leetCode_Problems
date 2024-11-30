class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        for (int i : nums){
            numsSet.add(i);
        }

        for(int i = 0; i <=nums.length; i++){
            if(!numsSet.contains(i)) return i;
        }
        return -1;
    }
}
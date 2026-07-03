class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int start = -1;
        int max = 0;

        for(int element : set){
            if(!set.contains(element-1)){
                start = element;

                int count = 1;
                
                while(set.contains(start+1)){
                start ++;
                count++;
                }
            max = Math.max(max,count);
            }
        }
    return max;
    }
}

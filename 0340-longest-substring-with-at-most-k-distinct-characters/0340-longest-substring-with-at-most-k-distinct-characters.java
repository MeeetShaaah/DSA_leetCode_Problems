// so basically this question can be solve using sliding window and hashmap, why hashmap? we have to check the frequency and based on that we have to run the condition,  
// the map size shouold be same as k because, k distinct ccharacters.

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.size()>k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
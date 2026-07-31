class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int max = 0;

        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}



// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left = 0;
//         int right = 0;

//         HashSet<Character> hset = new HashSet<>();
//         int max = 0;

//         while (right < s.length()) {

//             while (hset.contains(s.charAt(right))) {
//                 hset.remove(s.charAt(left));
//                 left++;
//             }

//             max = Math.max(max, right - left + 1);
//             hset.add(s.charAt(right));
//             right++;
//         }
//         return max;
//     }
// }
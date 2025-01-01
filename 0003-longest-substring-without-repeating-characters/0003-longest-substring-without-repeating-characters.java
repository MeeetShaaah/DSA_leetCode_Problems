// Approch - 2, find optimal approach, have to decrease TC from O(n2) to O(n), the question is that how to do this?
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

// Approch - 1, the brute force one will be like, start from index - 0 and inner loop from index i, check every possible substring and count, TC - O(n2)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         int n = s.length();

//         for (int i = 0; i < n; i++){
//             int count = 0;
//             HashSet<Character> set = new HashSet<>();

//             for(int j = i; j < n; j++){
//                 if (set.contains(s.charAt(j))){
//                     break;
//                 }

//                 set.add(s.charAt(j));
//                 count++;
//             }
//             max = Math.max(max, count);
//         }
//         return max;
//     }
// }
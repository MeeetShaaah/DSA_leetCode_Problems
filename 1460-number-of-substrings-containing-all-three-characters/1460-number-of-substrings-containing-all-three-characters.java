class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0,0,0};
        int res = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            count[ch-'a']++;

            while(count[0] >= 1 && count[1] >= 1 && count[2] >= 1){
                count[s.charAt(left) - 'a']--;
                left++;
            }

            res += left;
        }

        return res;
    }
}

// class Solution {
//     public int numberOfSubstrings(String s) {
//         int left = 0;
//         int right = 0;
//         int[] freq = new int[3];
//         int answer = 0;

//         while(right < s.length()){
//             freq[s.charAt(right) - 'a']++;

//             while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
//                 answer += s.length() - right;

//                 freq[s.charAt(left) - 'a']--;
//                 left++;
//             }
//         right++;
//         }
//         return answer;
//     }
// }

// used Chat GPT to solve this question,

class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0, length = 0;


        while (right < s.length()){
            charFreq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }

            length = Math.max(length, right - left +1);
            right++;
        }        
        return length;
    }
}
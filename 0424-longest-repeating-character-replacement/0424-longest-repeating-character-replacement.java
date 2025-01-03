// GPT
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxFreq = 0, maxLength = 0;
        int[] charCount = new int[26];  // Frequency array for A-Z

        while (right < s.length()) {
            // Increase the frequency of the current character
            charCount[s.charAt(right) - 'A']++;
            // Track the maximum frequency of any character in the window
            maxFreq = Math.max(maxFreq, charCount[s.charAt(right) - 'A']);
            
            // Window size: (right - left + 1)
            // If (window size - maxFreq) > k, shrink the window
            if ((right - left + 1) - maxFreq > k) {
                // Decrement frequency of left character and shrink
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update the maxLength of the window
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
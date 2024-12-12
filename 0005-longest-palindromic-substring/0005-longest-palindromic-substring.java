class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return ""; // Handle empty string case
        String longest = "";
        
        for (int i = s.length() - 1; i >= 0; i--) { // Outer loop for end index
            for (int j = 0; j <= i; j++) {         // Inner loop for start index
                
                String currentSubstring = s.substring(j, i + 1);
                
                // Check if the current substring is a palindrome
                if (isPalindrome(currentSubstring)) {
                     if (currentSubstring.length() > longest.length()){
                        longest = currentSubstring;
                     } // Return the first longest palindrome
                }
            }
        }
        return longest; // If no palindrome found, return empty string
    }

    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // If mismatch, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If all characters match, it's a palindrome
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        return check(0, s.length() - 1, s);
    }

    private boolean check(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return check(i + 1, j - 1, s);
        } else {
            return false;
        }
    }
}
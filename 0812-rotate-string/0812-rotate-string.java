class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String doubleStrings = s + s;

        return doubleStrings.contains(goal);
    } 
}
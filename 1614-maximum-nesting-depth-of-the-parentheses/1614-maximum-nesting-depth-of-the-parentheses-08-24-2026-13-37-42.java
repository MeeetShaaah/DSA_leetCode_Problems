class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int counter = 0;

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                counter++;
            }

            if (ch == ')') {
                counter--;
            }

            max = Math.max(max, counter);
        }
        return max;
    }
}
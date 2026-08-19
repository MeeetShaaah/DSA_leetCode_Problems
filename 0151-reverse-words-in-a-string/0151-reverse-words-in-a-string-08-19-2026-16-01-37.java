class Solution {
    public String reverseWords(String s) {
        int reader = s.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (reader >= 0) {
            while (reader >= 0 && s.charAt(reader) == ' ') {
                reader--;
            }

            if (reader < 0) {
                break;
            }

            int end = reader;

            while (reader >= 0 && s.charAt(reader) != ' ') {
                reader--;
            }

            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(s.substring(reader + 1, end + 1));
        }
        return sb.toString();
    }
}
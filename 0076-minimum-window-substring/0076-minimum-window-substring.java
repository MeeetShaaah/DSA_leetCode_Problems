// (Self) understand the logic to crack but i dont know how to write the code,

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || s.length() < t.length() || t.length() == 0) return "";
        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c : t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> sFreq = new HashMap<>();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0; 

        while (right < s.length()){
            char c = s.charAt(right);
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
            if(tFreq.containsKey(c) && sFreq.get(c).equals(tFreq.get(c))){
                formed++;
            }

            while(formed == tFreq.size()){
                char startChar = s.charAt(left);

                if(right - left + 1 < minLen){
                    start = left;
                    minLen = right - left + 1; 
                }

                sFreq.put(startChar, sFreq.getOrDefault(startChar, 0) - 1);

                if (tFreq.containsKey(startChar) && sFreq.get(startChar) < tFreq.get(startChar)) {
                    formed--;
                }
                left++;
            }   
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
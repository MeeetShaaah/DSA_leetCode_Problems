class Solution {
    public int beautySum(String s) {
        int beauty = 0;
        for(int left = 0; left < s.length(); left++){

            Map<Character, Integer> map = new HashMap<>();

            for(int right = left; right < s.length(); right++){
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int frequency : map.values()) {
                    max = Math.max(max, frequency);
                    min = Math.min(min, frequency);
                }

                beauty += max - min;
            }
        }
        return beauty;
    }
}
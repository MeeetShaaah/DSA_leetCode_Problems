// Approch - 1, i was sure that this can be solve using map, because there is a frequency thing in the question, but i didnt know how to sort keys from map.
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> characters = new ArrayList<>(map.keySet());
        Collections.sort(characters, (a,b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        for (char c : characters){
            int count = map.get(c);
            for (int i = 0; i < count; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
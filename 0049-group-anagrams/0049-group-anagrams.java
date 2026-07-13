class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            char[] freq = new char[26];
            
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            String key = new String(freq);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
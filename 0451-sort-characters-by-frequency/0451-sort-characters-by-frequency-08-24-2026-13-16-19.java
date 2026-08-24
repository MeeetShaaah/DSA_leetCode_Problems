class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        List<Character> list = new ArrayList<>(map.keySet());
        // list.sort((a,b) -> b.getValue() - a.getValue());
        // Collections.sort(list, (a,b) -> b.getValue() - a.getValue());
        Collections.sort(
            list,
            (a,b) -> map.get(b) - map.get(a)
        );

        StringBuilder sb = new StringBuilder();

        // for(Map.Entry<Character, Integer> entry : list){
        //     for(int i = 0; i < entry.getValue(); i++){
        //         sb.append(entry.getKey());
        //     }
        // }

        for(Character ch : list){
            for(int i = 0; i < map.get(ch); i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
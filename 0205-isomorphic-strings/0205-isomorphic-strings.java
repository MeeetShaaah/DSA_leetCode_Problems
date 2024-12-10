class Solution {
    public boolean isIsomorphic(String s, String t) {
        return transforming(s).equals(transforming(t));
    }

    private String transforming(String t){
        Map<Character, Integer> map = new HashMap<>();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < t.length(); i++){
            
            if (!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), i);
            }

            sb.append(Integer.toString(map.get(t.charAt(i))));
            sb.append(" ");
        }
        return sb.toString();
    }
}
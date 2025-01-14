// (Self), TC - O(n2)
class Solution {
    public List<String> stringMatching(String[] words) {

        Set<String> result = new HashSet<>();

        for(int i = 0; i <  words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i !=j && words[i].contains(words[j])){
                    result.add(words[j]);
                }
            }
        } 
        return new ArrayList<>(result); //you can directly convert set to ArrayList, i didnt know that, keep this in mind. 
    }
}
// BruteForce
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //Lambda function to sort list.
        list.sort((a,b) -> b.getValue() - a.getValue());

        int[] top = new int[k];

        for(int i = 0; i  < k; i++){
            top[i] = list.get(i).getKey();
        }

        return top;
    }
}